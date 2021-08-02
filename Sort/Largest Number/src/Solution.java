import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

	public static void main(String[] args) {
		int[] numbers = {40,404};
		System.out.println(solution(numbers));

	}

	public static String solution(int[] numbers) {
		String answer = "";
		PriorityQueue<String> queue = new PriorityQueue<String>(new Comparator<String>() {
			public int compare(String o1, String o2) {
				return Integer.parseInt(o2+o1)-Integer.parseInt(o1+o2);
			}
			
		});
        for (int a : numbers) queue.add(Integer.toString(a));
        while (!queue.isEmpty()) answer += queue.poll();
        if (answer.charAt(0) == '0') return "0";
        return answer;
	}
	
}
