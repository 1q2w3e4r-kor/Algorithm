import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuffer str = new StringBuffer();
		for(int r=0;r<n;r++) {
			int k = Integer.parseInt(br.readLine());
			PriorityQueue<Long> q = new PriorityQueue<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<k;i++) q.add(Long.parseLong(st.nextToken()));
			long cnt=(long)0;
			while(q.size()>1) {
				long a=q.poll()+q.poll();
				cnt+=a;
				q.add(a);
			}
			str.append(cnt+"\n");
		}
		System.out.print(str);
	}
}

