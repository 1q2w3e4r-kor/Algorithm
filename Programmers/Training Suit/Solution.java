import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {
		int n =3;
		int[] lost = {1,2};
		int[] reserve= {2,3};
		System.out.println(solution(n, lost,reserve));
	}
	
	public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        HashMap<Integer,Integer> res = new HashMap<>();
        HashMap<Integer,Integer> los = new HashMap<>();
        for(int a: lost) los.put(a, 0);
        for(int a: reserve) {
        	if(los.containsKey(a)) los.remove(a);
        	else res.put(a, 0);
        }
        for(int i: los.keySet()) {
        	if(res.containsKey(i-1)) res.remove(i-1);
        	else if(res.containsKey(i+1)) res.remove(i+1);
        	else answer--;
        }
        return answer;
    }
}
