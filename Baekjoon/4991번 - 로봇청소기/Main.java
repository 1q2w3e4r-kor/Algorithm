import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int x;
	static int y;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int dis[][][][];
	static char[][] arr;
	static ArrayList<Pos> clean;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			if(x==0 && y==0) break;
			arr = new char[x][y];
			int cx=0,cy=0;
			clean = new ArrayList<>();
			dis= new int[20][20][20][20];
			boolean[][] visited = new boolean[x][y];
			for(int i=0;i<y;i++) {
				String tmp = br.readLine();
				for(int j=0;j<x;j++) {
					char ch = tmp.charAt(j);
					arr[j][i]=ch;
					if(ch=='o') {
						cx=j;
						cy=i;
						visited[j][i]=true;
					}else if(ch=='*') {
						clean.add(new Pos(j,i,0));
					}
				}
			}
			System.out.println(bfs(new Pos(cx,cy,0),visited,0));
		}
	}
	
	public static int bfs(Pos pos, boolean[][] visited,int cnt) {
		int min = -1;
		boolean isClean =false;
		for(int i =0; i<clean.size();i++) {
			Pos next = clean.get(i);
			int nx = next.x;
			int ny = next.y;
			if(visited[nx][ny])continue;
			isClean = true;
			visited[nx][ny] = true;
			int distance;
			if(dis[pos.x][pos.y][next.x][next.y]==0) {
				distance = dist(pos,next);
				dis[pos.x][pos.y][next.x][next.y] = distance;
				if(distance==-1) return -1;
			}
			else distance = dis[pos.x][pos.y][next.x][next.y];
			int comp = bfs(next,visited,cnt+distance);
			visited[nx][ny] = false;
			if(comp==-1) return -1;
			if(min == -1) min = comp;
			else if(comp<min) min = comp;
		}
		if(!isClean) return cnt;
		return min;
	}
	
	public static int dist(Pos start,Pos target) {
		int sx = start.x;
		int sy = start.y;
		boolean[][] visited = new boolean[x][y];
		PriorityQueue<Pos> q = new PriorityQueue<>();
		q.add(new Pos(sx,sy,0));
		visited[sx][sy] = true;
		while(!q.isEmpty()) {
			Pos pos = q.poll();
			int cx = pos.x;
			int cy = pos.y;
			if(cx==target.x && cy==target.y) 
				return pos.cnt;
			for(int i=0;i<4;i++) {
				int nx = cx+dx[i];
				int ny = cy+dy[i];
				if(nx<0 ||ny<0||nx>=x||ny>=y) continue;
				else if(visited[nx][ny]) continue;
				else if(arr[nx][ny]=='x') continue;
				visited[nx][ny] = true;
				q.add(new Pos(nx,ny,pos.cnt+1));
			}
		}
		return -1;
	}
	
}

class Pos implements Comparable<Pos> {
	int x;
	int y;
	int cnt;
	
	Pos(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pos o) {
		return cnt - o.cnt;
	}
}