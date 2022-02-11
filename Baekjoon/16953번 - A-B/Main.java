import java.io.*;
import java.util.StringTokenizer;

public class Main{
	static long to;
	static int min = Integer.MAX_VALUE;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long from = Long.parseLong(st.nextToken());
		to = Long.parseLong(st.nextToken());
		dfs(from,1);
		if(min==Integer.MAX_VALUE) min=-1;
		System.out.print(min);
	}
	
	public static void dfs(long from,int idx) {
		if(to<from) return;
		else if(to==from) {
			min = Math.min(min, idx);
			return;
		}
		dfs(from*2,idx+1);
		dfs(Long.parseLong(Long.toString(from)+"1"),idx+1);
	}
}