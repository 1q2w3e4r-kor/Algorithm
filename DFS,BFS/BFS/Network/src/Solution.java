import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public static void main(String[] args) {
		int n=4;
		int[][] computers= {{1, 1, 0, 1}, {1, 1, 0 ,0}, {0, 0, 1,1}, {1, 0, 1, 1}};
		System.out.println(solution(n,computers));
	}
	
	public static int solution(int n, int[][] computers) {
        int answer = 1;
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =1 ;i<computers.length;i++) map.put(i, 0);
        queue.add(0);
        while(!map.isEmpty()) {
        	if(queue.isEmpty()) {
        		for(int a: map.keySet()) {
        			queue.add(a);
        			answer+=1;
        			map.remove(a);
        			break;
        		}
        	}
        	int idx = queue.poll();
        	int[] conn = computers[idx];
        	for(int i=0;i<conn.length;i++) {
        		if(conn[i]==1 && map.containsKey(i)) {
        			queue.add(i);
        			map.remove(i);
        		}
        	}
        }
        return answer;
    }

}
