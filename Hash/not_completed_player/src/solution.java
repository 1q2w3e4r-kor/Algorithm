import java.util.HashMap;

public class solution {

	public static void main(String[] args) {
		String[] participant = { "mislav", "stanko", "mislav", "ana" };
		String[] completion = { "stanko", "ana", "mislav" };
		System.out.print(solution(participant, completion));
	}

	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String,Integer> map1 = new HashMap<String,Integer>();
		for(String p: participant) {
			if(map1.get(p)!= null) {
				map1.replace(p, map1.get(p)+1);
				continue;
			}
			map1.put(p, 1);
		}
		for(String c: completion) if(map1.get(c)!=null) map1.replace(c,map1.get(c)-1);
		for(String a: map1.keySet()) if(map1.get(a)==1) answer = a;
		
		return answer;
	}

}
