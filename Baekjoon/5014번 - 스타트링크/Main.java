import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int top = Integer.parseInt(st.nextToken());
		int cur = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		int up = Integer.parseInt(st.nextToken());
		int dw = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[top+1];
		PriorityQueue<Floor> q = new PriorityQueue<>();
		q.add(new Floor(cur,0));
		visited[cur] = true;
		while(!q.isEmpty()) {
			Floor floor = q.poll();
			int fl = floor.fl;
			int cnt = floor.cnt;
			if(fl==target) {
				System.out.print(cnt);
				return;
			}
			int df = fl-dw;
			int uf = fl+up;
			
			if(df>=1){
				if(!visited[df]) {
				visited[df]=true;
				q.add(new Floor(df,cnt+1));
				}
			}
			
			if(uf<=top){
				if(!visited[uf]) {
				visited[uf]=true;
				q.add(new Floor(uf,cnt+1));
				}
			}
		}
		System.out.print("use the stairs");
	}
}

class Floor implements Comparable<Floor>{
	int fl;
	int cnt;
	Floor(int fl,int cnt){
		this.fl=fl;
		this.cnt=cnt;
	}
	@Override
	public int compareTo(Floor o) {
		// TODO Auto-generated method stub
		return cnt-o.cnt;
	}
	
}
