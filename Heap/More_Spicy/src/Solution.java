import java.util.Collections;
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
        while(pq.peek()<=K) {
        	int first = pq.poll();
        	int second = pq.poll();
        	pq.add(first+second*2);
        	answer++;
        	System.out.println(first+" "+second+" "+(first+second*2));
        }
        while(!pq.isEmpty()) System.out.print(pq.poll()+" ");
        System.out.println();
        return answer;
    }
}
