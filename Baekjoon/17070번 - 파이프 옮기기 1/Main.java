import java.io.*;
import java.util.StringTokenizer;

public class Main{
	static int n;
	static int[][] arr;
	static int cnt=0;
	static boolean[][] visited;
	static int[] dx = {1,0,1};
	static int[] dy = {0,1,1};
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visited = new boolean[n][n];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(1,0,0);
		System.out.print(cnt);
	}
	public static void dfs(int x, int y , int prev) {
		if(x==n-1 && y == n-1) {
			cnt++;
			return;
		}
		for(int i=0;i<3;i++) {
			if((prev==0 && i==1)||(prev==1 && i==0)) continue;
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx>=n || ny>=n) continue;
			if(arr[ny][nx] == 1) continue;
			if(i==2) if(arr[ny-1][nx] ==1|| arr[ny][nx-1]==1) continue;
			dfs(nx,ny,i);
		}
	}
}