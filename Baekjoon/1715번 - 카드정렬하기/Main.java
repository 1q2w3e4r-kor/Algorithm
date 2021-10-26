import java.io.*;
import java.util.PriorityQueue;

public class Main{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i =0 ;i<num;i++) q.add(Integer.parseInt(br.readLine()));
		int cnt=0;
		while(q.size()!=1) {
			int sum = q.poll()+q.poll();
			cnt+=(sum);
			q.add(sum);
		}
		System.out.println(cnt);
	}
}
