import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {
		int[] prices= {1,2,3,2,3,1};
		for(int a: solution(prices))
			System.out.print(a+" ");

	}
	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<prices.length;i++) map.put(i,prices[i]);
        int cnt;
        for(int i=0;i<map.size();i++) {
        	cnt=0;
        	for(int j=i+1;j<map.size();j++) {
        		cnt++;
        		if(map.get(i)>map.get(j)) break;
        	}
        	answer[i]=cnt;
        }
        return answer;
    }
}