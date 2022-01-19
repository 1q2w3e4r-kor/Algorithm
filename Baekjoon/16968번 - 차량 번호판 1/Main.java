import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer str = new StringBuffer(br.readLine());
		int c = 0, d = 0, cc = 0, cd = 0,prev=-1,cnt=0;
		int total=1;
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i)=='c') {
				c++;
				if(prev != 0) { 
					cd = Math.max(cd, cnt);
					cnt=1;
				}else cnt++;
				prev = 0;
			}else {
				d++;
				if(prev != 1) { 
					cc = Math.max(cc, cnt);
					cnt=1;
				}else cnt++;
				prev = 1;
			}
			if(i==str.length()-1) {
				if(prev == 0) cc = Math.max(cc, cnt);
				else cd = Math.max(cd, cnt);
			}
		}
		if(cd>0) total = (int) (Math.pow(10, d-cd+1) *Math.pow(9, cd-1));
		if(cc>0) total *= (int) (Math.pow(26, c-cc+1) *Math.pow(25, cc-1));
		System.out.println(total);
	}
}