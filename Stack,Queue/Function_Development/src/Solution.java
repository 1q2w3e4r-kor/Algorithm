import java.util.ArrayList;

public class Solution {

	public static void main(String[] args) {
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5 };
		for (int a : solution(progresses, speeds))
			System.out.print(a + " ");
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		ArrayList<Integer> arr = new ArrayList<>();
		int total=0,cnt;
		while (total != progresses.length) {
			cnt=0;
			for (int i = total ;i<progresses.length;i++) {
				if(i==total&&progresses[total]>=100) {
					cnt++;
					total++;
				}
				else progresses[i]+=speeds[i];
			}
			if(cnt!=0) 	arr.add(cnt);
		}
		int[] answer = new int[arr.size()];
		cnt=0;
		for(int a : arr) answer[cnt++]=a; 

		return answer;
	}
}

