import java.io.*;
import java.util.StringTokenizer;

public class Main{
	static int[][] arr = new int[10][10];
	static boolean[][] visited = new boolean[10][10];
	static int num =0;
	static int total=0;
	static int[] paper = {0,5,5,5,5,5};
	static int result = Integer.MAX_VALUE;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<10;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<10;j++) {
				int tmp = Integer.parseInt(st.nextToken());
				arr[i][j] = tmp;
				if(tmp == 1) num++;
			}
		}
		bf(0,0,0);
		if(result == Integer.MAX_VALUE) result = -1;
		System.out.print(result);
	}
	public static void bf(int x,int y,int cnt) {
		if(x>9 && y==9) {
			if(total == num) result = Math.min(result, cnt);
			return;
		}
		if(x>9) {
			bf(0,y+1,cnt);
			return;
		}
		if(result<=cnt) return;
		else if(visited[y][x]) bf(x+1,y,cnt); 
		else if(arr[y][x]==1) {
			for(int i=5;i>0;i--) {
				if(paper[i]!=0 && sz(x,y,i)) {
					paper[i]-=1;
					for(int a=y;a<y+i;a++) {
						for(int b=x;b<x+i;b++) {
							visited[a][b] = true;
						}
					}
					total+=i*i;
					bf(x+1,y,cnt+1);
					paper[i]+=1;
					for(int a=y;a<y+i;a++) {
						for(int b=x;b<x+i;b++) {
							visited[a][b] = false;
						}
					}
					total-=i*i;
				}
			}
		}else {
			bf(x+1,y,cnt);
		}
	}
	
	public static boolean sz(int x,int y,int size) {
		for(int i=y;i<y+size;i++) {
			for(int j=x;j<x+size;j++) {
				if(i>9 || j>9) return false;
				if(arr[i][j]!=1) return false;
				if(visited[i][j]) return false;
			}
		}
		return true;
	}
}