import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {

		int brown=24;
		int yellow=24;
		for(int a: solution(brown,yellow)) System.out.print(a+" ");
		

	}

	public static int[] solution(int brown,int yellow) {
		HashMap<Integer,Integer> map = new HashMap<>();
		int total = brown+yellow;
		for(int i =3;i*i<= total;i++) if(total%i==0) map.put(total/i, i);
		for(int a:map.keySet()) {
			if((a*2+(map.get(a)-2)*2)==brown) {
				int[] answer= {a,map.get(a)};
				return answer;
			}
		}
		return null;
	}

}
