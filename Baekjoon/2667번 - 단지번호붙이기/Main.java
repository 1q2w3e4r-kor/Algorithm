import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[][] = new int[n][n];
		boolean visited[][] = new boolean[n][n];
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		HashMap<String, Integer> map = new HashMap<>();
		ArrayList<Integer> vil = new ArrayList<>();
		
		for(int i =0;i<n;i++) {
			String tmp = sc.next();
			for(int j=0;j<n;j++) {
				int h= Integer.parseInt(tmp.substring(j,j+1));
				arr[j][i] = h;
				if(h==1) map.put(Integer.toString(j)+" "+Integer.toString(i) , 0);
			}
		}
		sc.close();
		
		while(!map.isEmpty()) {
			Queue<int[]> queue = new LinkedList<>();
			int cnt=0;
			for(String a:map.keySet()) {
				String[] tcur = a.split(" ");
				int tx = Integer.parseInt(tcur[0]);
				int ty = Integer.parseInt(tcur[1]);
				queue.add(new int[] {tx,ty});
				visited[tx][ty] = true;
				map.remove(a);
				break;
			}
			
			while(!queue.isEmpty()) {
				cnt++;
				int[] cur = queue.poll();
				int x = cur[0];
				int y = cur[1];
				for(int i=0;i<4;i++) {
					int nx = x+dx[i];
					int ny = y+dy[i];
					if(nx <0 || ny<0 || nx==n || ny==n) continue;
					else if(visited[nx][ny] == true || arr[nx][ny]==0) continue;
					else {
						queue.add(new int[] {nx,ny});
						visited[nx][ny]= true;
						map.remove(Integer.toString(nx)+" "+Integer.toString(ny));
					}
				}
			}
			vil.add(cnt);
		}
		Collections.sort(vil);
		System.out.println(vil.size());
		for(int a: vil) System.out.println(a);
	}
}