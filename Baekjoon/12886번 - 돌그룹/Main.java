import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] group = new int[3];
		boolean[][] visited = new boolean[1501][1501];
		for(int i=0;i<3;i++) group[i] = Integer.parseInt(st.nextToken());
		if((group[0] + group[1] + group[2]) % 3 != 0) {
			System.out.print(0);
			return;
		}
		Queue<int[]> q = new LinkedList<>();
		q.add(group);
		while(!q.isEmpty()) {
			int[] g = q.poll();
			Arrays.sort(g);
			int a = g[0];
			int b = g[1];
			int c = g[2];
			if(a==b &&b==c) {
				System.out.print(1);
				return;
			}
			if(a!=b && !visited[a][b]) {
				visited[a][b]=true;
				q.add(new int[] {a*2,b-a,c});
			}
			if(a!=c && !visited[a][c]) {
				visited[a][c]=true;
				q.add(new int[] {a*2,b,c-a});
			}
		}
		System.out.print(0);
	}
}