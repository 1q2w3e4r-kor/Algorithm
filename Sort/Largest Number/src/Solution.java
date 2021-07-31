import java.util.Arrays;
import java.util.Collections;

public class Solution {

	public static void main(String[] args) {
		int[] numbers = {40,404};
		System.out.println(solution(numbers));

	}

	public static String solution(int[] numbers) {
		String answer = "";
		
		String[] snumbers = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
		Arrays.sort(snumbers, Collections.reverseOrder());
		String stmp;
		for(int i=0;i<snumbers.length-1;i++) {
			for(int j=i+1;j<snumbers.length;j++) {
				if(snumbers[i].charAt(0)!=snumbers[j].charAt(0)) break;
				if(snumbers[i].length()==snumbers[j].length()) {
					if(snumbers[i].compareTo(snumbers[j])<0) {
						stmp=snumbers[i];
						snumbers[i]=snumbers[j];
						snumbers[j]=stmp;
					}
				}else if(snumbers[i].length()>snumbers[j].length()) {
					if(snumbers[i].charAt(1)<snumbers[i].charAt(0)) {
						stmp=snumbers[i];
						snumbers[i]=snumbers[j];
						snumbers[j]=stmp;
					}else if(snumbers[i].charAt(1)==snumbers[i].charAt(0)) {
						if(snumbers[i].charAt(2)<snumbers[i].charAt(1)) {
							stmp=snumbers[i];
							snumbers[i]=snumbers[j];
							snumbers[j]=stmp;
						}
					}
				}
			}
		}		
		for (String a : snumbers)answer += a;
		if (answer.charAt(0) == 0)return "0";
		return answer;
	}
	
}
