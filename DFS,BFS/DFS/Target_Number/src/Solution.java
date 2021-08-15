
public class Solution {

	public static void main(String[] args) {
		int[] numbers= {1, 1, 1, 1, 1};
		int target=3;
		System.out.println(solution(numbers,target));
	}
	
	public static int solution(int[] numbers, int target) {
        int answer = 0;
        answer+=dfs(numbers,0,target,numbers[0]);
        answer+=dfs(numbers,0,target,-numbers[0]);
        return answer;
    }

	
	static int dfs(int[] numbers,int idx,int target,int cur) {
		int ans=0;
		if(idx>=numbers.length-1) {
			if(target==cur) return 1;
			else return 0;
		}
		idx++;
		int curPos = cur + numbers[idx];
		int curNeg = cur-numbers[idx];
		ans+=dfs(numbers,idx,target,curPos);
		ans+=dfs(numbers,idx,target,curNeg);
		return ans;
	}
}
