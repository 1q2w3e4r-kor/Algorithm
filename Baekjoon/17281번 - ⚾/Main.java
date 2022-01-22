import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] arr;
	static boolean[] visited = new boolean[9];
	static int[] bat = new int[9];
	static int max = Integer.MIN_VALUE;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][9];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0);
		System.out.print(max);
	}
	
	public static void dfs(int idx) {
		if(idx==9) {
			score();
			return;
		}
		if(idx==3) {
			bat[3] = 0;
			dfs(idx+1);
		}else {
			for(int i=1;i<9;i++) {
				if(visited[i]) continue;
				visited[i] = true;
				bat[idx] = i;
				dfs(idx+1);
				visited[i] = false;
			}
		}
	}
	
	public static void score() {
		int total=0;
		int order=0;
		for(int i=0;i<n;i++) {
			int out =0;
			Queue<Integer> q = new LinkedList<>();
			for(int j=order;j<9;j++) {
				if(out==3) {
					order =j;
					break;
				}
				int res = arr[i][bat[j]];
				if(res==0) 
					out++;
				else if(res==4) {
					total+=(q.size()+1);
					q.clear();
				}else {
					int size = q.size();
					for(int k =0;k<size;k++) {
						int base = q.poll();
						int cur = base + res;
						if(cur >3) total+=1;
						else q.add(cur);
					}
					q.add(res);
				}
				if(j==8) j=-1;
			}
		}
		max = Math.max(max, total);
	}
}