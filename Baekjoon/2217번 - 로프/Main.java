import java.io.*;
import java.util.PriorityQueue;

public class Main{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i =0 ;i<num;i++) {
			int rope = Integer.parseInt(br.readLine());
			q.add(rope);
		}
		int max =q.poll()*num;
		for(int i=num-1;i>0;i--) {
			int rope = q.poll();
			if(rope*i > max) max=rope*i;
		}
		System.out.println(max);
	}
}