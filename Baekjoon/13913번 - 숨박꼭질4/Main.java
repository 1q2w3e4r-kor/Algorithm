import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		if(start>end) {
			System.out.println(start-end);
			for(int i=start;i>=end;i--) System.out.print(i+" ");
			return;
		}
		Queue<Path> q = new LinkedList<>();
		HashMap<Integer,Integer> map = new HashMap<>();
		q.add(new Path(start));
		while(!q.isEmpty()) {
			Path path = q.poll();
			int cur = path.cur;
			if(cur==end) {
				System.out.println(path.cnt);
				System.out.print(path.path);
				break;
			}
			map.put(cur, 0);
			
			if(cur<end) {
				if(!map.containsKey(cur*2)) {
					q.add(new Path(2*cur,path.cnt+1,path.path+Integer.toString(2*cur)+" "));
				}
				if(!map.containsKey(cur+1)) {
					q.add(new Path(cur+1,path.cnt+1,path.path+Integer.toString(cur+1)+" "));
				}
			}
			if(!map.containsKey(cur-1) && cur>=0) {
				q.add(new Path(cur-1,path.cnt+1,path.path+Integer.toString(cur-1)+" "));
			}
		}
	}
}

class Path{
	int cur;
	int cnt=0;
	String path="";
	Path(int cur){
		this.cur=cur;
		this.path=cur+" ";
	}
	Path(int cur,int cnt,String path){
		this.cur=cur;
		this.cnt= cnt;
		this.path=path;
	}
}

