import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, l, r;
	static int[][] arr;
	static boolean[][] visited;
	static int cnt;
	static Queue<Pos> sq = new LinkedList<>();
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,1,-1};
	static int idx=0;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		int total =0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int tmp= Integer.parseInt(st.nextToken());
				arr[j][i] = tmp;
				total+=tmp;
			}
		}
		
		int aver = total/(n*n);
		while (true) {
			boolean open= false;
			visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[j][i]) {
						sq.add(new Pos(j,i));
						cnt=0;
						if(bfs(j, i)) {
							open =true;
						}
					}
				}
			}
			if(!open) break;
			boolean ch=true;
			idx++;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(arr[j][i]!=aver) {
						ch=false;
						break;
					}
				}
				if(!ch) break;
			}
			if(ch) break;
		}
		System.out.print(idx);

	}
	
	public static boolean bfs(int x,int y) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(x,y));
		visited[x][y]=true;
		cnt+=arr[x][y];
		boolean ch = false;
		while(!q.isEmpty()) {
			Pos pos = q.poll();
			for(int i=0;i<4;i++) {
				int nx = pos.x+dx[i];
				int ny = pos.y+dy[i];
				if(nx<0 ||ny<0||nx>=n||ny>=n) continue;
				if(visited[nx][ny]) continue;
				int abs = Math.abs(arr[nx][ny]-arr[pos.x][pos.y]);
				if(abs>=l && abs<=r) {
					ch = true;
					Pos p = new Pos(nx,ny);
					visited[nx][ny] = true;
					cnt+=arr[nx][ny];
					q.add(p);
					sq.add(p);
				}
			}
		}
		int num = cnt/sq.size();
		while(!sq.isEmpty()) {
			Pos pos =sq.poll();
			arr[pos.x][pos.y] = num;
		}
		return ch;
	}
}

class Pos{
	int x,y;
	Pos(int x,int y){
		this.x=x;
		this.y=y;
	}
}
