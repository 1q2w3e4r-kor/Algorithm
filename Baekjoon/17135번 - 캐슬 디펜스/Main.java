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
	
	//�ü��� ��ġ ����
	public static void dfs(int idx, int prev) {
		// 3���� �ü��� ��ġ�� �������� �ִ� ����� ���� ������ �� �ִ��� Ȯ��
		if (idx == 3) {
			max = Math.max(shcnt(), max);
			return;
		}
		// �ߺ� ���� �ü��� ��ġ�� ����
		for (int i = prev; i < m; i++) {
			arc[idx] = i;
			dfs(idx + 1, prev + 1);
		}
	}
	
	// ��ġ�� ������ �ü��� ����� ���� ���� �� �ִ���
	public static int shcnt() {
		// ���� �� ǥ���ϴ� �迭
		boolean[][] visited = new boolean[n][m];
		// ���� �� ī��Ʈ
		int cnt = 0;
		// �ü��� Ÿ�� ��ǥ
		int[] tx = new int[3];
		int[] ty = new int[3];
		// n -> �ü��� ��ġ, �ü��� ���� �ö󰣴ٰ� �����ߴ�
		for (int i = n - 1; i >= 0; i--) {
			// �ü��� Ÿ�� ����
			for (int a = 0; a < 3; a++) {
				int min = Integer.MAX_VALUE;
				tx[a] = -1;
				// �ü� �ٷ� ������ ����
				for (int j = i; j >= 0; j--) {
					for (int k = 0; k < list[j].size(); k++) {
						//�Ÿ� ���
						int comp = Math.abs(list[j].get(k) - arc[a]) + (i + 1 - j);
						// �Ÿ��� ���� �Ÿ����� �����ų� ������
						if (comp <= d) {
							// ���� ���� ������ Ȯ��
							if (!visited[j][list[j].get(k)]) {
								// ������ Ÿ�� ����
								if (comp < min) {
									tx[a] = list[j].get(k);
									ty[a] = j;
									min = comp;
								// �Ÿ��� ������ �� ���ʿ� ������ Ÿ�� ����
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
				// Ÿ������ ������ ���� ���� ��� (-1�̸� ����)
				if (tx[a] != -1) {
					// �ش� ���� ���� ���� ���� ���
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