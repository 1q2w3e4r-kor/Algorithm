import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int x;
	static int y;
	static int n;
	static int size = 2;
	static int exp = 0;
	static int cnt=0;
	static int[][] arr;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		Queue<Fish> q = new LinkedList<>();
		for (int j = 0; j < n; j++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp == 9) {
					x = i;
					y = j;
					tmp=0;
				}else if (tmp > 0) q.add(new Fish(i, j, tmp));
				arr[i][j] = tmp;
			}
		}
		
		while (true) {
			if (q.isEmpty()) break;
			Queue<Fish> pq = new LinkedList<>();
			int stmp = q.size();
			for(int i=0;i<stmp;i++) {
				Fish tmp = q.poll();
				if(tmp.size < size) {
					pq.add(tmp);
				}else {
					q.add(tmp);
				}
			}
			if (pq.isEmpty()) break;
			
			Fish nfish = pq.poll();
			int min= distance(nfish);
			if(min==Integer.MAX_VALUE) {
				if(nfish.vis) break;
				nfish.vis=true;
				q.addAll(pq);
				q.add(nfish);
				continue;
			}
			stmp = pq.size();
			for(int i=0;i<stmp;i++) {
				Fish fish = pq.poll();
				int fx = fish.x;
				int fy = fish.y;
				int comp = distance(fish);
				if(comp==Integer.MAX_VALUE) {
					pq.add(fish);
					continue;
				}
				if(comp<min) {
					min = comp;
					pq.add(nfish);
					nfish = fish;
				}else if(comp==min) {
					if(y-nfish.y < y-fy) {
						pq.add(nfish);
						nfish = fish;
					}else if(y-nfish.y == y-fy) {
						if(x-nfish.x < x-fx) {
							pq.add(nfish);
							nfish = fish;
						}else {
							pq.add(fish);
						}
					}else {
						pq.add(fish);
					}
				}else {
					pq.add(fish);
				}
			}
			q.addAll(pq);
			x=nfish.x;
			y=nfish.y;
			arr[x][y]=0;
			cnt+=min;
			exp++;
			if(exp==size) {
				size++;
				exp=0;
			}
		}
		System.out.print(cnt);
	}
	
	public static int distance(Fish fish) {
		int fx = fish.x;
		int fy = fish.y;
		PriorityQueue<Fish> q = new PriorityQueue<>();
		boolean visited[][] = new boolean[n][n];
		q.add(new Fish(x,y,0));
		visited[x][y]=true;
		while(!q.isEmpty()) {
			Fish shark = q.poll();
			int sx = shark.x;
			int sy = shark.y;
			if(fx==sx &&fy==sy)
				return shark.size;
			for(int i=0;i<4;i++) {
				int nx = sx+dx[i];
				int ny = sy+dy[i];
				if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
				else if(visited[nx][ny])continue;
				else if(arr[nx][ny]>size) continue;
				visited[nx][ny]=true;
				if(size<arr[nx][ny]) continue;
				q.add(new Fish(nx,ny,shark.size+1));
			}
			
		}
		return Integer.MAX_VALUE;
	}
}





class Fish implements Comparable<Fish> {
	int x;
	int y;
	int size;
	boolean vis = false;

	Fish(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
	}

	@Override
	public int compareTo(Fish o) {
		// TODO Auto-generated method stub
		return size - o.size;
	}
}