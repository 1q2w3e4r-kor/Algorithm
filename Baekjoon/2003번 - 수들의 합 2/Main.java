import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		long dp[] = new long[n+1];
		st = new StringTokenizer(br.readLine());
		int cnt=0;
		for(int i=1;i<=n;i++) {
			long tmp = Long.parseLong(st.nextToken());
			if(tmp==m) cnt++;
			dp[i] = dp[i-1] + tmp;
		}
		
		for(int i=2;i<=n;i++) {
			for(int j=0;j<=n-i;j++) {
				if(dp[j+i]-dp[j]==m) 
					cnt++;
			}
		}
		System.out.print(cnt);
	} 
}