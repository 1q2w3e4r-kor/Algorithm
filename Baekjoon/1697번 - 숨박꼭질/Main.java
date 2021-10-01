import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		sc.close();
		queue.add(n);
		map.put(n, 0);
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			int cnt = map.get(cur);
			if (cur == k) {
				System.out.print(cnt);
				break;
			}
			if (cur < k) {
				if (!map.containsKey(2 * cur)) {
					map.put(2 * cur, cnt + 1);
					queue.add(2 * cur);
				}
				if (!map.containsKey(cur + 1)) {
					map.put(cur + 1, cnt + 1);
					queue.add(cur + 1);
				}
			}
			if (!map.containsKey(cur - 1) && cur > 0) {
				map.put(cur - 1, cnt + 1);
				queue.add(cur - 1);
			}
		}
	}
}