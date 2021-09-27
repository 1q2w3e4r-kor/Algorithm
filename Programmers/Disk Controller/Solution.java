import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

	public static void main(String[] args) {
		int[][] jobs = {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}};
		System.out.println(solution(jobs));
	}

	public static int solution(int[][] jobs) {
		int answer = 0;

		PriorityQueue<Integer[]> pq = new PriorityQueue<>(new Comparator<Integer[]>() {
			public int compare(Integer[] o1, Integer[] o2) {
				return o1[1] - o2[1];
			}
		});
		PriorityQueue<Integer[]> queue = new PriorityQueue<>(new Comparator<Integer[]>() {
			public int compare(Integer[] o1, Integer[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		for (int[] a : jobs) {
			Integer ijobs[] = Arrays.stream(a).boxed().toArray(Integer[]::new);
			queue.add(ijobs);
		}

		int time = 0;
		while (!queue.isEmpty() || !pq.isEmpty()) {
			if (!queue.isEmpty()) {
				while (time >= queue.peek()[0]) {
					pq.add(queue.remove());
					if (queue.isEmpty()) break;
				}
			}
			if (pq.isEmpty())time = queue.peek()[0];
			else {
			Integer[] job = pq.poll();
			time += job[1];
			answer += time - job[0];
			}
		}
		return answer / jobs.length;
	}
}
