import java.io.*;
import java.util.StringTokenizer;

public class Main{
	static char[][] arr= new char[5][5];
	static boolean[] visited= new boolean[1000000];
	static int cnt=0;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0;i<5;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				arr[i][j] = st.nextToken().charAt(0);
			}
		}
		
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				dfs(j,i,0,"");
			}
		}
		System.out.print(cnt);
	}
	public static void dfs(int x,int y,int idx,String snum) {
		if(idx==6) {
			int num = Integer.parseInt(snum.toString());
			if(!visited[num]) {
				visited[num] = true;
				cnt++;
			}
			return;
		}
		snum+=arr[y][x];
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0 || ny<0||nx>=5 || ny>=5) continue;
			dfs(nx,ny,idx+1,snum);
			if(idx!=0)snum = snum.substring(0,snum.length());
		}
	}
}