import java.util.ArrayList;

public class Solution {

	public static void main(String[] args) {
		String number = "4177252841";
		int k = 4;
		System.out.println(solution(number, k));
	}

	public static String solution(String number, int k) {
		StringBuilder num = new StringBuilder(number);
		for(int i=0;i<k;i++) {
			int len=num.length();
			int idx=len-1;
			for(int j=0;j<len-1;j++) {
				if(num.charAt(j)<num.charAt(j+1)) {
					idx=j;
					break;
				}
			}
			num.deleteCharAt(idx);
		}
		return num.toString();
	}
}
