import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = { 7, 4, 5, 6 };
		System.out.println(solution(bridge_length, weight, truck_weights));
	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		int curWeight = 0, truckCnt = 0, truckPassed = 0;
		Queue<Integer> truck = new LinkedList<>();
		Queue<Integer> bridge = new LinkedList<>();
		HashMap<Integer, Integer> truckTime = new HashMap<>();
		
		for (int a : truck_weights)truck.add(a);

		while (!bridge.isEmpty() || !truck.isEmpty()) {
			answer++;
			if(truckCnt!=0) {
				if (answer == (truckTime.get(truckPassed) + bridge_length)) {
					curWeight -= bridge.poll();
					truckPassed++;
				}
			} 
			
			if (!truck.isEmpty()) {
				if (truck.peek() + curWeight <= weight) {
					curWeight += truck.peek();
					bridge.add(truck.poll());
					truckTime.put(truckCnt++, answer);
				}
			}

		}
		return answer;
	}
}
