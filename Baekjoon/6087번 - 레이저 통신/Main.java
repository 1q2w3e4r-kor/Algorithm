import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		char[][] arr = new char[w][h];
		ArrayList<Pos> target = new ArrayList<>();

		for (int i = 0; i < h; i++) {
			String str = br.readLine();
			for (int j = 0; j < w; j++) {
				char tmp = str.charAt(j);
				arr[j][i] = tmp;
				if (tmp=='C') target.add(new Pos(j, i, 0, -1));
			}
		}

		PriorityQueue<Pos> q = new PriorityQueue<>();
		int visited[][] = new int[w][h];
		q.add(target.get(0));
		visited[target.get(0).x][target.get(0).y] = 1;
		int tx = target.get(1).x;
		int ty = target.get(1).y;
		while (!q.isEmpty()) {
			Pos pos = q.poll();
			int x = pos.x;
			int y = pos.y;
			int prev = pos.prev;
			int cnt = pos.cnt;
			if (x == tx && y == ty) {
				System.out.println(cnt);
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || ny < 0 || nx >= w || ny >= h|| arr[nx][ny]=='*') continue;
				
				int ncnt = cnt;
				if(prev != i && prev != -1) {
					ncnt++;
				}
				if(visited[nx][ny] ==0 || visited[nx][ny] >= ncnt) {
					visited[nx][ny]=ncnt;
					q.add(new Pos(nx,ny,ncnt,i));
				}
			}
		}
		
	}
}

class Pos implements Comparable<Pos> {
	int x;
	int y;
	int cnt;
	int prev;

	Pos(int x, int y, int cnt, int prev) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.prev = prev;
	}

	@Override
	public int compareTo(Pos o) {
		return cnt - o.cnt;
	}

}