import java.util.Scanner;

public class Main {
	static int[][] arr;
	static int[][] way;
	static int mx;
	static int my;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		my = sc.nextInt();
		mx = sc.nextInt();
		arr = new int[mx][my];
		way = new int[mx][my];
		for (int i = 0; i < my; i++) {
			for (int j = 0; j < mx; j++) {
				arr[j][i] = sc.nextInt();
				way[j][i]=-1;
			}
		}
		sc.close();
		System.out.print(dfs(0, 0));
	}

	public static int dfs(int x, int y) {
		if (x == mx - 1 && y == my - 1)	return 1;
		if(way[x][y]!=-1) return way[x][y];
		way[x][y]=0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < mx && ny < my) {
					if (arr[x][y] > arr[nx][ny]) way[x][y] += dfs(nx, ny);
			}
		}
		return way[x][y];
	}
}