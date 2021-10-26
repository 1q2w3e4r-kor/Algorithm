import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> nq = new PriorityQueue<>();
		
		int zero=0;
		for(int i =0 ;i<num;i++) {
			int n =Integer.parseInt(br.readLine());
			if(n>0) pq.add(n);
			else if(n==0) zero++;
			else nq.add(n);
		}
		int sum =0 ;
		while(!pq.isEmpty()) {
			if(pq.size()==1) sum+=pq.poll();
			else {
				int f = pq.poll();
				int s = pq.poll();
				if(s==1) sum+=(f+s);
				else sum+=(f*s);
			}
		}
		while(!nq.isEmpty()) {
			if(nq.size()==1) {
				if(zero>0) sum+=(nq.poll()*0);
				else sum+=nq.poll();
			}
			else {
				int f = nq.poll();
				int s = nq.poll();
				sum+=(f*s);
			}
		}
		System.out.println(sum);
	}
}