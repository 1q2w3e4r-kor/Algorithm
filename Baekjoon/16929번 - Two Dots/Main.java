import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int x;
	static int y;
	static int tx;
	static int ty;
	static char[][] arr;
	static boolean[][] visited;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		y =Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		arr = new char[x][y];
		visited = new boolean[x][y];
		for(int i=0;i<y;i++) {
			String str = br.readLine();
			for(int j=0;j<x;j++) {
				arr[j][i] = str.charAt(j);
			}
		}
		
		for(int i=0;i<y;i++) {
			for(int j=0;j<x;j++) {
				if(!visited[j][i]) {
					tx =j;
					ty =i;
					if(isC(new Pos(tx,ty,1))) {
						System.out.print("Yes");
						return;
					}
				}
			}
		}
		System.out.print("No");
	}
	
	public static boolean isC(Pos p){
		if(p.x == tx && p.y == ty && p.cnt>=4) return true;
		for(int i=0;i<4;i++) {
			int nx = p.x+dx[i];
			int ny = p.y +dy[i];
			if(nx<0||ny<0||nx>=x||ny>=y) continue;
			else if(visited[nx][ny]) continue;
			else if(arr[p.x][p.y] != arr[nx][ny]) continue;
			visited[nx][ny] =true;
			if(isC(new Pos(nx,ny,p.cnt+1))) return true;
			visited[nx][ny] =false;
		}
		return false;
	}
}

class Pos{
	int x;
	int y;
	int cnt;
	
	Pos(int x,int y,int cnt){
		this.x=x;
		this.y=y;
		this.cnt= cnt;
	}
	
}
