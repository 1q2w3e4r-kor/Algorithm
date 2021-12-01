import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[][] arr;
	static ArrayList<Virus> virus;
	static int min = Integer.MAX_VALUE;
	static int total;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr=new int[n][n];
		virus = new ArrayList<>();
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp==2) {
					virus.add(new Virus(j,i));
					tmp=0;
				}else if(tmp==1) total++;
				arr[j][i] = tmp;
			}
		}
		ArrayList<Virus> list = new ArrayList<>();
		boolean visited[] = new boolean[virus.size()];
		total = n*n-total-m;
		bfs(0,list,visited);
		if(min == Integer.MAX_VALUE) min = -1;
		System.out.print(min);
	}

	static void bfs(int idx,ArrayList<Virus> list,boolean[] visited) {
		if(list.size()==m) {
			int comp = dfs(list);
			if(comp<min) min = comp;
			return;
		}
		for(int i=idx;i<virus.size();i++) {
			if(visited[i]) continue;
			visited[i]=true;
			list.add(virus.get(i));
			bfs(i,list,visited);
			list.remove(virus.get(i));
			visited[i]=false;
		}
	}
	
	static int dfs(ArrayList<Virus> list) {
		int[][] darr = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				int tmp = arr[j][i];
				if(tmp==1) tmp=-1;
				darr[j][i]=tmp;
			}
		}
		Queue<ArrayList<Virus>> q = new LinkedList<>();
		q.add(list);
		boolean visited[][]= new boolean[n][n];
		for(int i=0;i<list.size();i++) visited[list.get(i).x][list.get(i).y]=true;
		int cnt=1;
		int t = total;
		while(!q.isEmpty()) {
			list=q.poll();
			ArrayList<Virus> tlist = new ArrayList<>();
			for(int i=0;i<list.size();i++) {
				int x = list.get(i).x;
				int y = list.get(i).y;
				for(int j=0;j<4;j++) {
					int nx = x+dx[j];
					int ny = y+dy[j];
					if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
					else if(visited[nx][ny]) continue;
					visited[nx][ny]=true;
					if(darr[nx][ny] == -1) continue;
					darr[nx][ny]=cnt;
					tlist.add(new Virus(nx,ny));
					t--;
				}
			}
			if(tlist.size()!=0) q.add(tlist);
			cnt++;
		}
		if(t!=0) return Integer.MAX_VALUE;
		return cnt-2;
	}
}

class Virus{
	int x;
	int y;
	
	Virus(int x,int y) {
		this.x=x;
		this.y=y;
	}
}
