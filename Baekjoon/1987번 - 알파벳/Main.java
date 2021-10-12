import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static String[][] arr;
	static boolean[][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int mx;
	static int my;
	static HashMap<String, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		my = sc.nextInt();
		mx = sc.nextInt();
		arr = new String[mx][my];
		visited = new boolean[mx][my];
		for (int i = 0; i < my; i++) {
			String tmp = sc.next();
			for (int j = 0; j < mx; j++) {
				arr[j][i] = tmp.substring(j, j + 1);
			}
		}
		sc.close();
		map.put(arr[0][0], 0);
		
		visited[0][0] = true;
		System.out.print(dfs(0, 0, 1));

	}

	public static int dfs(int x, int y, int idx) {
		int max = idx;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < mx && ny < my && !map.containsKey(arr[nx][ny]) && visited[nx][ny] == false) {
				map.put(arr[nx][ny], 0);
				visited[nx][ny] = true;
				int tmp = dfs(nx, ny, idx + 1);
				if (tmp > max)max = tmp;
				map.remove(arr[nx][ny]);
				visited[nx][ny] = false;
			}
		}
		return max;
	}
}