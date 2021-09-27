import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {

	public static void main(String[] args) {
		int[] people = {70, 80, 50};
		int limit = 100;
		System.out.println(solution(people,limit));
	}
	
	public static int solution(int[] people, int limit) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        ArrayDeque<Integer> deq = new ArrayDeque<>(50000);
        for(int a:people) list.add(a);
        Collections.sort(list);
        for(int a:list) deq.add(a);
        while(!deq.isEmpty()) {
        	int total= deq.pollLast();
        	if(!deq.isEmpty() && limit-total>=deq.peekFirst()) deq.pollFirst();
        	answer++;
        }
        return answer;
    }
}
