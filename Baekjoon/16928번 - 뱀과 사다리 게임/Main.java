import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int l = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int[] path = new int[101];
		boolean[] visited = new boolean[101];
		PriorityQueue<Pos> q = new PriorityQueue<>();
		for(int i =0;i<l+s;i++) {
			st = new StringTokenizer(br.readLine());
			path[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		q.add(new Pos(1,0));
		while(!q.isEmpty()) {
			Pos pos = q.poll();
			int cur = pos.cur;
			int cnt = pos.cnt;
			if(cur == 100) {
				System.out.print(cnt);
				break;
			}
			
			for(int i=1;i<7;i++) {
				int ncur = cur+i;
				if(ncur>100) continue;
				if(visited[ncur]) continue;
				visited[ncur]=true;
				if(path[ncur]!=0) {
					ncur = path[ncur];
					q.add(new Pos(ncur,cnt+1));
				}else {
					q.add(new Pos(ncur,cnt+1));
				}
			}
		}
	}
}

class Pos implements Comparable<Pos>{
	int cur;
	int cnt;
	
	Pos(int cur, int cnt){
		this.cur=cur;
		this.cnt=cnt;
	}
	
	@Override
	public int compareTo(Pos o) {
		// TODO Auto-generated method stub
		return cnt-o.cnt;
	}
	
	
}