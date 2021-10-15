import java.util.HashMap;
import java.util.Scanner;



public class Main{
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,1,-1};
	static int[][] arr;
	static boolean[][] visited;
	static int x;
	static int y;
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int carr[] = new int[input];
		for(int i=0;i<input;i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			int k = sc.nextInt();
			arr = new int[x][y];
			visited = new boolean[x][y];
			
			int cnt=0;
			for(int j=0;j<k;j++) {
				arr[sc.nextInt()][sc.nextInt()] = 1;
			}
			for(int m=0;m<y;m++) {
				for(int n=0;n<x;n++) {
					if(arr[n][m]==1 && visited[n][m] == false) {
						dfs(n,m);
						cnt++;
					}
				}
			}
			carr[i]=cnt;
		}
		for(int a: carr) System.out.println(a);
	}
	
	public static void dfs(int n, int m) {
		visited[n][m] = true;
		for(int i =0 ; i<4;i++) {
			int nx = n+dx[i];
			int ny = m+dy[i];
			if(nx>=0&&ny>=0&& nx<x && ny<y) {
				if(arr[nx][ny]==1 && visited[nx][ny]==false) dfs(nx,ny);
			}
		}
	}
}



class loc{
	int x;
	int y;
	
	public loc(int x,int y) {
		this.x=x;
		this.y=y;
	}
}
