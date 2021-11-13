import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		PriorityQueue<Pos> q = new PriorityQueue<>();
		boolean[] visited = new boolean[100001];
		q.add(new Pos(start,0));
		while(!q.isEmpty()) {
			Pos pos = q.poll();
			int cur = pos.cur;
			int cnt = pos.cnt;
			if(cur == end) {
				System.out.print(cnt);
				break;
			}
			else if(visited[cur]) continue;
			visited[cur]=true;
			if(end>cur) {
				if(2*cur<=100000) q.add(new Pos(2*cur,cnt));
				if(cur+1<=100000) q.add(new Pos(cur+1,cnt+1));
			}
			if(cur>0) q.add(new Pos(cur-1,cnt+1));
		}
	}
}

class Pos implements Comparable<Pos>{
	int cur;
	int cnt;
	
	Pos(int cur,int cnt){
		this.cnt=cnt;
		this.cur=cur;
	}

	@Override
	public int compareTo(Pos o) {
		return cnt-o.cnt;
	}
}
