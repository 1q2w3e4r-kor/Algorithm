import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int arr[][] = new int[x][y];
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		int zeroes =0;
		Queue<int[]> queue = new LinkedList<>();
		
		for(int i =0;i<y;i++) {
			for(int j=0;j<x;j++) {
				int h= sc.nextInt();
				arr[j][i] = h;
				if(h==1) queue.add(new int[] {j,i});
				else if(h==0) zeroes++;
			}
		}
		sc.close();
		
		int days=-1;
		while(!queue.isEmpty()) {
			days++;
			Queue<int[]> ripe = new LinkedList<>();
			ripe.addAll(queue);
			queue.clear();
			while(!ripe.isEmpty()) {
				int[] cur = ripe.poll();
				for(int i =0;i<4;i++) {
					int nx = cur[0]+dx[i];
					int ny = cur[1]+dy[i];
					if(nx <0||ny<0||nx==x||ny==y) continue;
					else if(arr[nx][ny] != 0) continue;
					else {
						arr[nx][ny] = 1;
						queue.add(new int[] {nx,ny});
						zeroes--;
					}
				}
			}
		}
		if(zeroes != 0) System.out.print("-1");
		else System.out.print(days);
		
	}
}