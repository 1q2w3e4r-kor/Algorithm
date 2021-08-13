import java.util.PriorityQueue;

public class Solution {

	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		System.out.println(solution(scoville,7));
	}
	
	public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int a:scoville) pq.add(a);
        if(pq.peek()==null) return -1;
        while(pq.peek()<=K) {
        	int first = pq.poll();
        	if(pq.peek()==null) return -1;
        	int second = pq.poll();
        	pq.add(first+second*2);
        	answer++;
        	
        }
        return answer;
    }
}
