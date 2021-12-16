import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static ArrayList<Integer>[] list;
	static int[] arr;
	static boolean[] visited;
	static int start;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1];
		
		for(int i =1;i<n+1;i++) list[i]=new ArrayList<>();
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s =Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[s].add(e);
			list[e].add(s);
		}
		for(int i=1;i<n+1;i++) {
			visited = new boolean[n+1];
			arr = new int[n+1];
			arr[i]=1;
			visited[i]=true;
			start =i;
			if(cycle(i,0)) break;
		}
		
		for(int i=1;i<n+1;i++) {
			if(arr[i]!=1) {
				visited = new boolean[n+1];
				visited[i]=true;
				arr[i]=toCycle(i,1)+1;
			}
			System.out.print(arr[i]-1+" ");
		}
	}
	
	static boolean cycle(int i,int idx) {
		for(int to:list[i]) {
			if(to==start&&idx!=1) return true;
			else if(visited[to]) continue;
			visited[to] =true;
			arr[to]=1;
			if(cycle(to,idx+1)) return true;	
			arr[to]=0;
			visited[to] = false;
		}
		return false;
	}
	
	static int toCycle(int i,int idx) {
		for(int to:list[i]) {
			if(arr[to]==1) return idx;
			else if(visited[to]) continue;
			visited[to] =true;
			int index = toCycle(to,idx+1);
			if(index != 0 ) return index;
			visited[to] = false;
		}
		return 0;
	}
}