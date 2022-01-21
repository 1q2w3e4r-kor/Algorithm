import java.io.*;
import java.util.StringTokenizer;

public class Main{
	static int cnt=0;
	static int n,l,r,x;
	static int[] arr;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		l=Integer.parseInt(st.nextToken());
		r=Integer.parseInt(st.nextToken());
		x=Integer.parseInt(st.nextToken());		
		arr = new int[n];
		st= new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		dfs(0,0,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
		System.out.print(cnt);
	}	
	
	public static void dfs(int k,int idx,int sum,int min,int max) {
		if(idx>n) return;
		if(idx>1 && sum>=l && sum<=r && (max-min)>=x) {
			cnt++;
		}
		if(sum>r) return;
		for(int i=k;i<n;i++) {
			int num =arr[i];
			sum+=num;
			int mn = min ,mx = max;
			if(mn>num) mn =num;
			if(mx<num) mx = num;
			dfs(i+1,idx+1,sum,mn,mx);
			sum-=num;
		}
	}
}