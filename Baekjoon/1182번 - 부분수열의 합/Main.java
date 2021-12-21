import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int n,cnt=0;
	static long target,sum=0;
	static Long[] arr;
	static boolean[] visited;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		visited = new boolean[n];
		target= Long.parseLong(st.nextToken());
		arr=new Long[n];
		st= new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) arr[i]=Long.parseLong(st.nextToken());
		rec(0,-1);
		System.out.print(cnt);
	}

	public static void rec(int idx,int prev) {
		if(sum==target && prev!=-1) 
			cnt++;
		if(idx==n) return;
		for(int i=prev+1;i<n;i++) {
			if(visited[i]) continue;
			visited[i] =true;
			long cur = arr[i];
			sum+=cur;
			rec(idx+1,i);
			sum-=cur;
			visited[i]=false;
		}
	}
}