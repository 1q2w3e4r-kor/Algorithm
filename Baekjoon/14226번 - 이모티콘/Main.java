import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		Queue<Imot> q = new LinkedList<>();
		boolean visited[] = new boolean[1001];
		q.add(new Imot(1,0,0));
		while(!q.isEmpty()) {
			Imot imot = q.poll();
			int cur = imot.cur;
			if(visited[cur]==true) continue;
			else if(cur == num) {
				System.out.print(imot.cnt);
				break;
			}
			int cnt = imot.cnt;
			int clip = imot.clip;
			if(cur == clip) visited[cur] =true;
			if(clip==0) {
				q.add(new Imot(cur,cnt+1,cur));
				continue;
			}
			else if(num>cur){
				if(cur+clip <=1000) q.add(new Imot(cur+clip,cnt+1,clip));
				q.add(new Imot(cur,cnt+1,cur));
			}
			if(cur>1 && !visited[cur]) q.add(new Imot(cur-1,cnt+1,clip));
		}
	}
}

class Imot{
	int cur;
	int cnt;
	int clip;
	
	Imot(int cur,int cnt,int clip){
		this.cur=cur;
		this.cnt=cnt;
		this.clip=clip;
	}
}
