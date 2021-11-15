import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x1,x2,y1,y2;
		int[] dx= {-2,-2,0,0,2,2};
		int[] dy = {-1,1,-2,2,-1,1};
		boolean[][] visited = new boolean[n][n];
		x1 = Integer.parseInt(st.nextToken());
		y1 = Integer.parseInt(st.nextToken());
		x2 = Integer.parseInt(st.nextToken());
		y2 = Integer.parseInt(st.nextToken());
		if((x2-x1) % 2 !=0) {
			System.out.print(-1);
			return;
		}
		PriorityQueue<Pos> q = new PriorityQueue<>();
		q.add(new Pos(x1,y1,0));
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			int x = cur.x;
			int y = cur.y;
			if(visited[x][y]) continue;
			visited[x][y] =true;
			if(x==x2 && y==y2) {
				System.out.print(cur.cnt);
				return;
			}
			for(int i=0;i<6;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
				q.add(new Pos(nx,ny,cur.cnt+1));
			}
		}
		System.out.print(-1);
	}
}

class Pos implements Comparable<Pos>{
	int x;
	int y;
	int cnt;
	Pos(int x,int y,int cnt){
		this.x=x;
		this.y= y;
		this.cnt=cnt;
	}
	@Override
	public int compareTo(Pos o) {
		// TODO Auto-generated method stub
		return cnt-o.cnt;
	}
}