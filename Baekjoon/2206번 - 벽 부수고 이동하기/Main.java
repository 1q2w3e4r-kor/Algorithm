import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int y = sc.nextInt();
		int x = sc.nextInt();
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		int[][] arr = new int[x][y];
		boolean visited[][][] = new boolean[x][y][2];
		Queue<Path> queue = new LinkedList<>();
		
		for(int i =0 ;i<y;i++) {
			String tmp = sc.next();
			for(int j =0 ;j<x;j++) arr[j][i] = Integer.parseInt(tmp.substring(j,j+1));
		}
		sc.close();
		
		queue.add(new Path (0,0,1,false));
		visited[0][0][0] = true;
		
		while(!queue.isEmpty()) {
			Path path = queue.poll();
			int cx =path.x;
			int cy = path.y;
			int cnt = path.cnt;
			boolean cd = path.destroy;
			if(cx == x-1 && cy == y-1) {
				System.out.print(cnt);
				return;
			}
			for(int i=0;i<4;i++) {
				int nx = cx+dx[i];
				int ny = cy+dy[i];
				if(nx<0||ny<0||nx==x||ny==y) continue;
				if(arr[nx][ny]==0) {
					if(!cd  && !visited[nx][ny][0]) {
						queue.add(new Path (nx,ny,cnt+1,false));
						visited[nx][ny][0]=true;
					}else if(cd && !visited[nx][ny][1]) {
						queue.add(new Path (nx,ny,cnt+1,true));
						visited[nx][ny][1]=true;
					}
				}else{
					if(!cd) {
						queue.add(new Path (nx,ny,cnt+1,true));
						visited[nx][ny][1] = true;
					}
				}
				
			}
		}
		System.out.print(-1);
	}
}

class Path {	 
    int x;
    int y;
    int cnt;
    boolean destroy;
 
    public Path(int x, int y, int cnt, boolean destroy) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.destroy = destroy;
    }
}