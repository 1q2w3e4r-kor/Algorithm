import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		double s = Integer.parseInt(st.nextToken());
		double t = Integer.parseInt(st.nextToken());
		if(s==t) {
			System.out.println(0);
			return;
		}
		Queue<Num> q = new LinkedList<>();
		HashMap<Double,Integer> map = new HashMap<>();
		q.add(new Num(s*s,"*"));
		q.add(new Num(s+s,"+"));
		q.add(new Num(0,"-"));
		q.add(new Num(1,"/"));
		map.put(s*s,0);
		map.put(s*s,0);
		while(!q.isEmpty()) {
			Num num=q.poll();
			double number = num.s;
			if(number==t) {
				System.out.print(num.oper);
				return;
			}
			double add = number+number;
			double mul = number*number;
			if(number<t) {
				if(!map.containsKey(mul) && mul!=1) {
					q.add(new Num(mul,num.oper+"*"));
					map.put(mul,0);
				}
				if(!map.containsKey(add)) {
					q.add(new Num(add,num.oper+"+"));
					map.put(add,0);
				}
			}
		}
		System.out.print(-1);
	}
	
}

class Num{
	double s;
	String oper;
	
	Num(double s,String oper){
		this.s=s;
		this.oper=oper;
	}
	
}
