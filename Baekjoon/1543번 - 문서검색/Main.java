import java.io.*;

public class Main{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String dic = br.readLine();
		String sch = br.readLine();
		int total=0;
		int len = sch.length();
		for(int i =0;i<=dic.length()-len;i++) {
			if(dic.charAt(i)==sch.charAt(0)) {
				if(dic.substring(i, i+len).contains(sch)) {
					i=i+len-1;
					total++;
				}
			}
		}
		System.out.println(total);
	}
}