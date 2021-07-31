import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		int[] citations = {20,21,22,23};
		System.out.println(solution(citations));
	}

	public static int solution(int[] citations) {
		int answer = 0;
		Arrays.sort(citations);
		int start = 0, end = citations.length - 1;
		int cnt = (start + end) / 2;
		
		if (citations[cnt] >= end - cnt + 1) {
			do{
				answer = end - cnt + 1;
				cnt -= 1;
				if(cnt<start) {
					return end+1;
				}
			}while (citations[cnt] > end - cnt + 1);
		} else if (citations[cnt] < end - cnt + 1) {
			do{
				answer = end - cnt + 1;
				cnt += 1;
				if(cnt>end) {
					if(citations[end]==0) return 0;
					return 1;
				}
			}while (citations[cnt] < end - cnt + 1);
		}
		return answer;
	}
}
