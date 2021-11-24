import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[][] arr = new String[n][n];
		boolean[][] nvisited = new boolean[n][n];
		boolean[][] abnvisited = new boolean[n][n];
		int[] dx= {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		for(int i =0;i<n;i++) {
			String str = br.readLine();
			for(int j=0;j<n;j++) {
				arr[j][i]=str.substring(j,j+1);
			}
		}
		
		int ncnt =0;
		int abncnt=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(!nvisited[j][i]) {
					Queue<Pos> nq = new LinkedList<>();
					nvisited[j][i] = true;
					nq.add(new Pos(j,i));
					String color= arr[j][i];
					while(!nq.isEmpty()) {
						Pos pos = nq.poll();
						int x = pos.x;
						int y=pos.y;
						for(int k=0;k<4;k++) {
							int nx = x+dx[k];
							int ny = y+dy[k];
							if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
							else if(nvisited[nx][ny]) continue;
							if(arr[nx][ny].contentEquals(color)) {
								nvisited[nx][ny] = true;
								nq.add(new Pos(nx,ny));
							}
						}
					}
					ncnt++;
				}
				if(!abnvisited[j][i]) {
					Queue<Pos> abnq = new LinkedList<>();
					abnvisited[j][i] = true;
					abnq.add(new Pos(j,i));
					String color1= arr[j][i];
					String color2= color1;
					if(color1.contentEquals("R") || color1.contentEquals("G")) {
						color1 = "R";
						color2 = "G";
					}
					while(!abnq.isEmpty()) {
						Pos pos = abnq.poll();
						int x = pos.x;
						int y=pos.y;
						for(int k=0;k<4;k++) {
							int nx = x+dx[k];
							int ny = y+dy[k];
							if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
							else if(abnvisited[nx][ny]) continue;
							if(arr[nx][ny].contentEquals(color1)||arr[nx][ny].contentEquals(color2)) {
								abnvisited[nx][ny] = true;
								abnq.add(new Pos(nx,ny));
							}
						}
					}
					abncnt++;
				}
			}
		}
		System.out.print(ncnt+" "+abncnt);
	}
}


class Pos{
	int x;
	int y;
	
	Pos(int x, int y){
		this.x=x;
		this.y=y;
	}
}