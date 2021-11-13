import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n =Integer.parseInt(st.nextToken());
		int m =Integer.parseInt(st.nextToken());
		int[] dx = {1,-1,0,0};
		int[] dy= {0,0,1,-1};
		
		int[][] arr = new int[m][n];
		for(int i =0;i<m;i++) {
			String str= br.readLine();
			for(int j =0;j<n;j++){
				arr[i][j]=Integer.parseInt(str.substring(j, j+1));
			}
		}
		PriorityQueue<Pos> q = new PriorityQueue<>();
		q.add(new Pos(0,0,0));
		boolean[][] visited = new boolean[m][n];
		while(!q.isEmpty()) {
			Pos pos = q.poll();
			int x = pos.x;
			int y = pos.y;
			if(x==n-1 && y==m-1) {
				System.out.println(pos.cnt);
				break;
			}
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx<0 || ny<0 || nx== n || ny ==m) continue;
				else if(visited[ny][nx]) continue;
				visited[ny][nx]= true;
				if(arr[ny][nx]==1) q.add(new Pos(nx,ny,pos.cnt+1));
				else q.add(new Pos(nx,ny,pos.cnt));
			}
		}
	}
}

class Pos implements Comparable<Pos>{
	int x;
	int y;
	int cnt;
	
	Pos(int x, int y,int cnt) {
		this.x=x;
		this.y=y;
		this.cnt=cnt;
	}

	@Override
	public int compareTo(Pos o) {
		return cnt-o.cnt;
	}
}