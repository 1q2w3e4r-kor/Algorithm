import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {
		String[] phone_book = { "12", "123", "1235", "567", "88" };
		System.out.println(solution(phone_book));
	}

	public static boolean solution(String[] phone_book) {
		boolean answer = true;
		HashMap<String,Boolean> map = new HashMap<>();
		for (String p : phone_book)	map.put(p, true);
		for (String p: map.keySet()) {
			for(int i=1 ;i<p.length();i++) if(map.containsKey(p.substring(0,i))) return false;
		}
		return answer;
	}

}