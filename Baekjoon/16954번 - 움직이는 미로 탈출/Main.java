import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] dx = {0,1,-1,0,0,-1,1,1,-1};
	static int[] dy = {0,0,0,1,-1,-1,-1,1,1};
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] arr =new char[8][8];
		Queue<Pos> wall = new LinkedList<>(); 
		boolean[][] visited = new boolean[8][8];
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(0,7,0));
		visited[0][7] =true;
		
		for(int i=0;i<8;i++) {
			String str=br.readLine();
			for(int j=0;j<8;j++) {
				char tmp=str.charAt(j);
				if(tmp=='#') wall.add(new Pos(j,i,0));
				arr[j][i] = tmp;
			}
		}
		int prev = 0;
		while(!q.isEmpty()) {
			Pos pos = q.poll();
			int x =pos.x;
			int y=pos.y;
			if(x==7 && y==0) {
				System.out.print(1);
				return;
			}
			if(prev != pos.cnt) {
				int size = wall.size();
				for(int i=0;i<size;i++) {
					Pos w = wall.poll();
					int wx = w.x;
					int wy = w.y;
					arr[wx][wy]='.';
					wy+=1;
					if(wy<8) {
						wall.add(new Pos(wx,wy,0));
					}
				}
				for(int i=0;i<wall.size();i++) {
					Pos w = wall.poll();
					arr[w.x][w.y]='#';
					wall.add(w);
				}
				prev++;
				visited = new boolean[8][8];
			}
			if(wall.isEmpty()) {
				System.out.print(1);
				return;
			}
			
			if(arr[x][y]=='#') continue;
			
			for(int i=0;i<9;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx<0 || ny<0 || nx>=8|| ny>=8) continue;
				else if(i!=0 && visited[nx][ny]) continue;
				else if(arr[nx][ny]=='#') continue;
				visited[nx][ny]=true;
				q.add(new Pos(nx,ny,pos.cnt+1));
			}
		}
		System.out.print(0);
	}
}

class Pos{
	int x;
	int y;
	int cnt;
	Pos(int x,int y,int cnt) {
		this.x=x;
		this.y=y;
		this.cnt=cnt;
	}
}
