import java.io.*;
import java.util.StringTokenizer;

public class Main{
	static int n;
	static int[][] arr;
	static int sub = Integer.MAX_VALUE;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for(int i =0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				dfs(j,i);
			}
		}
		System.out.print(sub);
	}	
	public static void dfs(int x,int y) {
		for(int i=1;i<n-1;i++) {
			for(int j=1;j<n-1;j++) {
				if(x+i+j>=n || 0>y-i || y+j>=n) break;
				sub(x,y,i,j);
			}
		}
	}
	
	public static void sub(int x, int y, int q, int w) {
		int[][] city = new int[n][n];
		int[] sum=new int[5];
		int max =Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		boolean visited[][] = new boolean[n][n];
		for(int i=0;i<=q;i++) {
			city[x+i][y-i] = 5;
			city[x+w+i][y+w-i]=5;
		}
		for(int i=0;i<=w;i++) {
			city[x+i][y+i] = 5;
			city[x+q+i][y-q+i] =5;
		}
		
		for(int i=0;i<=y;i++) {
			for(int j=0;j<x+q;j++) {
				if(city[j][i] ==5) break;
				city[j][i] = 1;
				sum[0]+=arr[j][i];
				visited[j][i] =true;
			}
		}
		
		for(int i=y+1;i<n;i++) {
			for(int j=0;j<=x+w;j++) {
				if(city[j][i] ==5) break;
				city[j][i] = 2;
				sum[1]+=arr[j][i];
				visited[j][i] =true;
			}
		}
		
		for(int i=0;i<y-q+w;i++) {
			for(int j=n-1;j>=x+q;j--) {
				if(city[j][i] ==5) break;
				city[j][i] = 3;
				sum[2]+=arr[j][i];
				visited[j][i] =true;
			}
		}
		
		for(int i=y-q+w;i<n;i++) {
			for(int j=n-1;j>=x+w+1;j--) {
				if(city[j][i] ==5) break;
				city[j][i] = 4;
				sum[3]+=arr[j][i];
				visited[j][i] =true;
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(visited[j][i]) continue;
				city[j][i] = 5;
				sum[4]+=arr[j][i];
			}
		}
		for(int i=0;i<5;i++) {
			max = Math.max(max, sum[i]);
			min = Math.min(min, sum[i]);
		}
		sub = Math.min(sub, max-min);
	}
}