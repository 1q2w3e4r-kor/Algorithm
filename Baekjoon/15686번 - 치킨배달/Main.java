import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n,m,c=0,h=0;
	static int[][] arr;
	static int[][] chicken = new int[2500][2];
	static int[][] house = new int[2500][2];
	static int min = Integer.MAX_VALUE;
	static boolean[] visited;
	static Deque<Integer> q = new LinkedList<>();
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr= new int[n][n];
		for(int i =0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				int tmp = Integer.parseInt(st.nextToken()); 
				arr[i][j]=tmp;
				if(tmp == 2) {
					chicken[c][0] = i;
					chicken[c][1] = j;
					c++;
				}else if(tmp == 1) {
					house[h][0] =i;
					house[h][1] =j;
					h++;
				}
			}
		}
		visited=new boolean[c];
		dfs(0,0);
		System.out.print(min);
	}
	public static void dfs(int idx,int prev) {
		if(idx==m) return;
		for(int i=prev;i<c;i++) {
			if(visited[i]) continue;
			q.add(i);
			visited[i]=true;
			dis();
			dfs(idx+1,i+1);
			q.pollLast();
			visited[i]=false;
		}
	}
	public static void dis() {
		int size =q.size();
		int[] ctoh = new int[h];
		for(int i =0 ; i<size;i++) {
			int c = q.poll();
			q.add(c);
			int x = chicken[c][1];
			int y = chicken[c][0];
			for(int j=0;j<h;j++) {
				int hx = house[j][1];
				int hy = house[j][0];
				int d = Math.abs(hy-y)+Math.abs(hx-x);
				if(ctoh[j]==0) ctoh[j]=d;
				else ctoh[j]=Math.min(ctoh[j], d);
			}
		}
		int total=0;
		for(int i=0;i<h;i++) {
			total+=ctoh[i];
		}
		min = Math.min(min, total);
	}
}