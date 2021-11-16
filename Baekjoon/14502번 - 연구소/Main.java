import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int[][] arr;
	static int n,m;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int min = Integer.MAX_VALUE;
	static int one =0;
	static Queue<Pos> virus = new LinkedList<>();
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp==2) virus.add(new Pos(j,i));
				else if(tmp==1) one++;
				arr[i][j] = tmp;
			}
		}
		wall(0);
		System.out.print(n*m-one-min-virus.size()-3);
	}
	
	public static void wall(int d) {
		if(d==3) {
			vir();
			return;
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==0) {
					arr[i][j]=1;
					wall(d+1);
					arr[i][j]=0;
				}
			}
		}
	}
	
	public static void vir() {
		int[][] map = new int[n][m];
		int cnt=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j]=arr[i][j];
			}
		}
		Queue<Pos> q = new LinkedList<>();
		for(int i =0;i<virus.size();i++) {
			Pos p =virus.poll();
			q.add(p);
			virus.add(p);
		}
		while(!q.isEmpty()){
			Pos pos = q.poll();
			for(int i=0;i<4;i++) {
				int nx = dx[i] + pos.x;
				int ny = dy[i] +pos.y;
				if(nx<0 || ny<0 || nx>=m || ny>=n) continue;
				if(map[ny][nx]==0) {
					map[ny][nx]=2;
					q.add(new Pos(nx,ny));
					cnt++;
				}
			}
		}
		if(min>cnt) min=cnt;
	}
}

class Pos{
	int x;
	int y;
	Pos(int x,int y){
		this.x=x;
		this.y= y;
	}
}