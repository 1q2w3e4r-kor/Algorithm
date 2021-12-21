import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static long sum=0;
	static Long[] arr;
	static boolean[] visited;
	static boolean[] v;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		visited = new boolean[n];
		arr=new Long[n];
		v= new boolean[1000000000];
		StringTokenizer st= new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) arr[i]=Long.parseLong(st.nextToken());
		rec(0,-1);
		int i=1;
		while(true) {
			if(!v[i]) {
				System.out.print(i);
				return;
			}
			i++;
		}
	}

	public static void rec(int idx,int prev) {
		if(prev!=-1) v[(int) sum] = true;
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