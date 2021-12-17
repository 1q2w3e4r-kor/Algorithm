import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr= new int[n];
		int max=0;
		for(int i=0;i<n;i++) {
			int tmp = Integer.parseInt(br.readLine());
			if(max<tmp) max= tmp;
			arr[i]=tmp;
		}
		int[][] dp;
		if(max<4) dp = new int[4][4];
		else dp= new int[max+1][4];
		for(int i=1;i<4;i++) {
			for(int j=1;j<=i;j++) {
				dp[i][j]=1;
			}
		}
		for(int i=4;i<=max;i++) {
			dp[i][1]=dp[i-1][1];
			dp[i][2]=dp[i-2][2]+dp[i-2][1];
			dp[i][3]=dp[i-3][1]+dp[i-3][2]+dp[i-3][3];
		}
		StringBuffer str = new StringBuffer();
		for(int i=0;i<n;i++) {
			int total=0;
			for(int j=1;j<4;j++) total+=dp[arr[i]][j];
			str.append(total+"\n");
		}
		System.out.print(str);
	}
}