import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {

	public static void main(String[] args) {
		String[] operations = {"I 16","D 1"};
		for(int a: solution(operations))
			System.out.print(a+" ");

	}
	public static int[] solution(String[] operations) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(String a: operations) {
        	String[] comm=a.split(" ");
        	if(comm[0].equals("I")) pq.add(Integer.parseInt(comm[1]));
        	else if(comm[1].equals("-1")) pq.poll();
        	else {
        		PriorityQueue<Integer> tmp = new PriorityQueue<>(Collections.reverseOrder());
        		tmp.addAll(pq);
        		tmp.poll();
        		pq.clear();
        		pq.addAll(tmp);
        	}
        }
 
        int[] answer= {0,0};
        PriorityQueue<Integer> revpq = new PriorityQueue<>(Collections.reverseOrder());
        if(pq.isEmpty()) return answer;
        revpq.addAll(pq);
        answer[1]=pq.poll();
        answer[0]=revpq.poll();
        return answer;
    }
}
