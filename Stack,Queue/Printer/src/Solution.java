import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public static void main(String[] args) {
		int[] priorities = { 1, 2, 9, 3, 4, 5 };
		int location = 1;
		System.out.println(solution(priorities, location));
	}

	public static int solution(int[] priorities, int location) {
		int answer = 0,cnt=0;
		Queue<Integer> queue = new LinkedList<>();
		HashMap<Integer,Integer> map = new HashMap<>();
		for (int a : priorities) {
			queue.add(a);
			map.put(cnt, cnt++);
		}
		for(int i =0;i<priorities.length;i++) {
			int max=0;
			cnt=0;
			for(int a:queue) if(max < a) max=a;
			while(max!=queue.peek()) {
				queue.add(queue.poll());
				cnt++;
			}
			for(int a: map.keySet()) {
				if(map.get(a)<0) continue;
				if(map.get(a)<cnt) map.replace(a, map.get(a)-cnt+queue.size()-1);
				else map.replace(a,map.get(a)-cnt-1);
			}
			queue.poll();
			if(map.get(location)<0) return i+1;
		}
		
		return answer;
	}
}
