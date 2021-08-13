
import java.util.ArrayList;

public class Solution {

	public static void main(String[] args) {

		int[] answers = { 1,2,3,4,5 };
		for(int a:solution(answers)) {
			System.out.print(a+" ");
		}
		

	}

	public static int[] solution(int[] answers) {
		ArrayList<Integer> arr = new ArrayList<>();
		int[] cnt = {0,0,0};
		for (int i = 0; i < answers.length; i++) {
			int[] ans=new int[3];
			ans[0]=i%5+1;
			if (i % 2 == 0)
				ans[1] = 2;
			else {
				switch (i % 8 / 2) {
				case 0:
					ans[1] = 1;
					break;
				case 1:
					ans[1] = 3;
					break;
				case 2:
					ans[1] = 4;
					break;
				default:
					ans[1] = 5;
					break;
				}
			}

			switch (i % 10 / 2) {
			case 0:
				ans[2] = 3;
				break;
			case 1:
				ans[2] = 1;
				break;
			case 2:
				ans[2] = 2;
				break;
			case 3:
				ans[2] = 4;
				break;
			default:
				ans[2] = 5;
				break;
			}
			
			for(int j=0;j<3;j++) if(answers[i]==ans[j]) cnt[j]++;
		}
		
		int max=cnt[0];
		for(int i=1;i<3;i++) if(cnt[i]>max) max=cnt[i];
		for(int i=0;i<3;i++) if(cnt[i]==max) arr.add(i+1);
		int[] answer = new int[arr.size()];
		for(int i=0;i<arr.size();i++) answer[i]=arr.get(i);
		return answer;
	}
}
