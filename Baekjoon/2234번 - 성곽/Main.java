import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static Pos[][] arr;
	static int[][] rmarr;
	static boolean[][] wall;
	static int x;
	static int y;
	static int rooms=0;
	static boolean visited[][];
	static ArrayList<Integer> list;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		arr = new Pos[x][y];
		rmarr = new int[x][y];
		visited= new boolean[x][y];
		for(int i =0 ; i<y;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0;j<x;j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[j][i] = new Pos(num);
			}
		}
		list = new ArrayList<>();
		int max=0;
		for(int i =0 ; i<y;i++) {
			for(int j =0;j<x;j++) {
				if(!visited[j][i]) {
					int comp = room(j,i);
					if(comp>max) max =comp;
					list.add(comp);
					rooms++;
				}
			}
		}
		System.out.println(rooms);
		System.out.println(max);
		wall = new boolean[rooms][rooms];
		max=0;
		
		for(int i =0 ; i<y;i++) {
			for(int j =0;j<x;j++) {
				int comp = breakWall(j,i);
				if(max<comp) max=comp;
			}
		}
		System.out.println(max);
	} 
	
	static int breakWall(int j,int i) {
		int to = rmarr[j][i];
		Pos pos = arr[j][i];
		int max=0;
		if(pos.l==1 && j>0) {
			int end = rmarr[j-1][i];
			if(end!=to && !wall[to][end]) {
				wall[to][end] =true;
				int comp = list.get(to)+list.get(end);
				if(max<comp) max = comp;
			}
		}
		if(pos.r==1 && j<x-1) {
			int end = rmarr[j+1][i];
			if(end!=to && !wall[to][end]) {
				wall[to][end] =true;
				int comp = list.get(to)+list.get(end);
				if(max<comp) max = comp;
			}
		}
		if(pos.u==1 && i>0) {
			int end = rmarr[j][i-1];
			if(end!=to && !wall[to][end]) {
				wall[to][end] =true;
				int comp = list.get(to)+list.get(end);
				if(max<comp) max = comp;
			}
		}
		if(pos.d==1 && i<y-1) {
			int end = rmarr[j][i+1];
			if(end!=to && !wall[to][end]) {
				wall[to][end] =true;
				int comp = list.get(to)+list.get(end);
				if(max<comp) max = comp;
			}
		}
		return max;
	}
	
	static int room(int cx,int cy) {
		if(visited[cx][cy]) return 0;
		visited[cx][cy]=true;
		rmarr[cx][cy] = rooms;
		int cnt=1;
		Pos cur = arr[cx][cy];
		if(cur.l==0) cnt+=room(cx-1,cy);
		if(cur.r==0) cnt+=room(cx+1,cy);
		if(cur.u==0) cnt+=room(cx,cy-1);
		if(cur.d==0) cnt+=room(cx,cy+1);
		return cnt;
	}
	
}

class Room implements Comparable<Room>{
	int to;
	int end;
	int total;
	Room(int to,int end, int total){
		this.to=to;
		this.end=end;
		this.total=total;
	}
	
	public int compareTo(Room o) {
		return o.total-total;
	}
}

class Pos{
	int l=0;
	int r=0;
	int u=0;
	int d=0;
	Pos(int num){
		if(num>=8) {
			num-=8;
			d=1;
		}
		if(num>=4) {
			num-=4;
			r=1;
		}
		if(num>=2) {
			num-=2;
			u=1;
		}
		if(num>=1) {
			l=1;
		}
	}
}