import java.io.*;
import java.util.StringTokenizer;

public class Main{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] cnt = new int[n];
		for(int i =0;i<n;i++) {
			arr[i]= Integer.parseInt(st.nextToken());
			cnt[i] =Integer.MAX_VALUE;
		}
		cnt[0]=0;
		for(int i =0;i<n;i++) {
			if(i==0 || cnt[i]!=Integer.MAX_VALUE)for(int j=1;j<=arr[i];j++) {
				if(i+j<n) {
					if(cnt[i+j]>cnt[i]+1) cnt[i+j] = cnt[i]+1;
				}
			}
		}
		if(cnt[n-1]!=Integer.MAX_VALUE)System.out.print(cnt[n-1]);
		else System.out.print("-1");
	}
}