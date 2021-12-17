import java.io.*;
import java.util.StringTokenizer;

public class Main{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		int[][] dp = new int[n+1][n+1];
		StringTokenizer st= new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			dp[i][i] = 1;
			if(arr[i]==arr[i-1]) dp[i-1][i] = 1;
		}
		
		for(int i=2;i<n;i++) {
			for(int j=1;j<=n-i;j++) {
				if(dp[j+1][j+i-1] == 1&&arr[j]==arr[j+i])
					dp[j][j+i]=1;
			}
		}
		
		int q = Integer.parseInt(br.readLine());
		StringBuffer str=new StringBuffer();
		for(int i=0;i<q;i++) {
			st= new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());;
			int end = Integer.parseInt(st.nextToken());
			str.append(dp[start][end]+"\n");
		}
		System.out.print(str);
	}
}