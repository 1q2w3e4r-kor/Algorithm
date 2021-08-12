import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {
		String[][] clothes = { { "yelloawqwhat", "headgeara" }, { "yelloawhat", "headgeara" },
				{ "yellowhat", "headgeara" }, { "bluesusnglassses", "4" }, { "blsuesunglasses", "4" },
				{ "bluesunglasses", "4" }, { "greaen_turban", "headgear" }, { "green_turban", "headgear" } };
		System.out.println(solution(clothes));
	}

	public static int solution(String[][] clothes) {
		int count, answer = clothes.length;
		HashMap<String, String> map1 = new HashMap<>();
		HashMap<String, Integer> map2 = new HashMap<>();
		for (String[] a : clothes) map1.put(a[0], a[1]);
		for (String a : map1.values()) {
			count = 0;
			for (String b : map1.keySet()) {
				if (map1.get(b).equals(a))
					count++;
			}
			map2.put(a, count);
		}
		if (map2.size() > 1) {
			count = 1;
			for (String a : map2.keySet()) {
				count *= map2.get(a) + 1;
			}
			answer = count - 1;
		}
		return answer;
	}
}
