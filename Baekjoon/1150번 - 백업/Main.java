import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		PriorityQueue<a> q = new PriorityQueue<>(new Comparator<a>() {
			@Override
			public int compare(a o1, a o2) {
				return o1.dis-o2.dis;
			}
		});
		a[] arr = new a[n];
		int start = Integer.parseInt(br.readLine());
		int end;
		for(int i=0;i<n-1;i++) {
			end = Integer.parseInt(br.readLine());
			arr[i]= new a(i-1,i+1,end-start);
			q.add(arr[i]);
			start=end;
		}
		int cnt=0;
		int total=0;
		for(int i=0;i<k;i++) {
			a cur = q.poll();
			int dis = cur.dis;
			total+=dis;
			if(cnt==k-1) break;
			
			if(cur.l==-1) {
				arr[arr[cur.r].r].l = -1;
				q.remove(arr[cur.r]);
			}else if(cur.r==n-1) {
				arr[arr[cur.l].l].r = n-1;
				q.remove(arr[cur.l]);
			}else {
				int l = cur.l;
				int r = cur.r;
				q.remove(arr[l]);
				q.remove(arr[r]);
				arr[l].r=arr[r].r;
				arr[l].dis=arr[l].dis+arr[r].dis-dis;
				q.add(arr[l]);
				if(q.contains(arr[arr[r].r])) arr[arr[r].r].l = l;
			}
			cnt++;
		}
		System.out.println(total);
	}
}

class a{
	int l;
	int r;
	int dis;
	
	public a(int l,int r,int dis) {
		this.l= l;
		this.r=r;
		this.dis=dis;
	}
}