import java.util.Scanner;

public class Main {
	static int[][] arr;
	static int[][] way;
	static boolean[][] finished;
	static int n;
	static int max;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n][n];
		way = new int[n][n];
		finished = new boolean[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[j][i] = sc.nextInt();
				way[j][i]= -1;
			}
		}
		int max=1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
					int tmp = dfs(j,i);
					if(max<tmp) max= tmp;
			}
		}
		System.out.print(max);
		sc.close();
	}
	public static int dfs(int x,int y) {
		if(finished[x][y]==true) return way[x][y];
		if(way[x][y]!=-1) return 0;
		way[x][y]=1;
		for(int i =0; i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx>=0&&ny>=0&&nx<n&&ny<n) {
				if(arr[x][y]<arr[nx][ny]) {
					int tmp = dfs(nx,ny)+1;
					if(way[x][y]<tmp) way[x][y] = tmp;
				}
			}
		}
		finished[x][y]=true;
		return way[x][y];
	}
}