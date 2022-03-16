import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n, m, d;
	static int max = Integer.MIN_VALUE;
	static int[] arc = new int[3];
	static ArrayList<Integer>[] list;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = new ArrayList<>();
			for (int j = 0; j < m; j++) {
				if (Integer.parseInt(st.nextToken()) == 1)
					list[i].add(j);
			}
		}
		dfs(0, 0);
		System.out.print(max);
	}
	
	//궁수의 위치 결정
	public static void dfs(int idx, int prev) {
		// 3명의 궁수의 위치가 정해지면 최대 몇명의 적을 제거할 수 있는지 확인
		if (idx == 3) {
			max = Math.max(shcnt(), max);
			return;
		}
		// 중복 없이 궁수의 위치를 결졍
		for (int i = prev; i < m; i++) {
			arc[idx] = i;
			dfs(idx + 1, prev + 1);
		}
	}
	
	// 위치가 결정된 궁수가 몇명의 적을 죽일 수 있는지
	public static int shcnt() {
		// 죽은 적 표시하는 배열
		boolean[][] visited = new boolean[n][m];
		// 죽은 적 카운트
		int cnt = 0;
		// 궁수의 타겟 좌표
		int[] tx = new int[3];
		int[] ty = new int[3];
		// n -> 궁수의 위치, 궁수가 위로 올라간다고 생각했다
		for (int i = n - 1; i >= 0; i--) {
			// 궁수의 타겟 결정
			for (int a = 0; a < 3; a++) {
				int min = Integer.MAX_VALUE;
				tx[a] = -1;
				// 궁수 바로 위부터 시작
				for (int j = i; j >= 0; j--) {
					for (int k = 0; k < list[j].size(); k++) {
						//거리 계산
						int comp = Math.abs(list[j].get(k) - arc[a]) + (i + 1 - j);
						// 거리가 사정 거리보다 가깝거나 적으면
						if (comp <= d) {
							// 전에 죽은 적인지 확인
							if (!visited[j][list[j].get(k)]) {
								// 가까우면 타겟 변경
								if (comp < min) {
									tx[a] = list[j].get(k);
									ty[a] = j;
									min = comp;
								// 거리가 같으나 더 왼쪽에 있으면 타켓 변경
								} else if (comp == min && tx[a] > list[j].get(k)) {
									tx[a] = list[j].get(k);
									ty[a] = j;
								}
							}
						}
					}
				}
			}
			for (int a = 0; a < 3; a++) {
				// 타겟으로 설정한 적이 있을 경우 (-1이면 없음)
				if (tx[a] != -1) {
					// 해당 적이 죽은 적이 없을 경우
					if (!visited[ty[a]][tx[a]]) {
						visited[ty[a]][tx[a]] = true;
						cnt++;
					}
				}
			}
		}

		return cnt;
	}
}