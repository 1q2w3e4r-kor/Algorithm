import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public static void main(String[] args) {
		int[] prices= {1, 2, 3, 2, 3};
		for(int a: solution(prices))
			System.out.print(a+" ");

	}
	public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> queue = new LinkedList<>();
        for(int a: prices) queue.add(a);
        for(int i=0;i<prices.length;i++) {
        	int comp = queue.poll();
        	int cnt=1;
        	if(queue.isEmpty() || queue.size()==prices.length-1) cnt=0;
        	for(int a: queue) {
        		System.out.println(comp+" "+a);
        		if(comp<=a) {
	        		cnt++;
	        	}else break;
        	}
        	answer[i]=cnt;
        }
        return answer;
    }
}
