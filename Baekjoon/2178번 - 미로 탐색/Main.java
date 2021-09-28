import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int y = sc.nextInt();
		int x = sc.nextInt();
		int arr[][]=new int[y][x];
		int[] dx = { -1, 1, 0, 0 }; 
    	int[] dy = { 0, 0, -1, 1 };
		
		for(int i=0;i<y;i++) {
			String tmp = sc.next();
			for(int j=0;j<x;j++) {
				arr[i][j]=Integer.parseInt(tmp.substring(j,j+1));
			}
		}
		sc.close();
		
		Deque<int []> queue = new LinkedList<>();
		boolean[][] visited = new boolean[y][x];
		visited[0][0] = true;
		
		queue.add(new int[] {0,0});
		
		while(!queue.isEmpty()) {
			int curp[] = queue.poll();
			int curx = curp[0];
			int cury = curp[1];
			for(int i=0; i<4; i++) {
				int nx = curx + dx[i];
				int ny = cury + dy[i];
		                if (nx < 0 || ny < 0 || nx >= x || ny >= y) continue;
		                else if (visited[ny][nx] || arr[ny][nx] == 0) continue;
		                else {
	        		        queue.add(new int[] {nx, ny});
	        		        arr[ny][nx] = arr[cury][curx] + 1;
	                		visited[ny][nx] = true;
		                }
			}
		}
		for(int i=0;i<y;i++) {
			for(int j=0;j<x;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		System.out.print(arr[y-1][x-1]);
	}
}