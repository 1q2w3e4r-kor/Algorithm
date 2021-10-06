import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main{
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int[][] arr = new int[input][2];
		for(int i=0;i<input;i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		sc.close();
		Queue<num> q= new LinkedList<>(); 
		HashMap<Integer,Integer> map = new HashMap<>();
		
		for(int i=0;i<input;i++) {
			q.add(new num(arr[i][0],""));
			map.put(arr[i][0], 0);
			int des = arr[i][1];
			while(!q.isEmpty()) {
				num cur = q.poll();
				if(des==cur.num) {
					System.out.println(cur.route);
					break;
				}
				int ntmp; 
				ntmp = L(cur.num);
				if(!map.containsKey(ntmp)) {
					map.put(ntmp, 0);
					q.add(new num(ntmp,cur.route+"L"));
				}
				ntmp = R(cur.num);
				if(!map.containsKey(ntmp)) {
					map.put(ntmp, 0);
					q.add(new num(ntmp,cur.route+"R"));
				}
				ntmp = D(cur.num);
				if(!map.containsKey(ntmp)) {
					map.put(ntmp, 0);
					q.add(new num(ntmp,cur.route+"D"));
				}
				ntmp = S(cur.num);
				if(!map.containsKey(ntmp)) {
					map.put(ntmp, 0);
					q.add(new num(ntmp,cur.route+"S"));
				}
			}
			q.clear();
			map.clear();
		}
		
	}
	
	public static int D(int num) {
		return 2*num%10000;
	}
	
	public static int S(int num) {
		return (num + 9999) % 10000;
	}
	
	public static int L(int num){
		return (num * 10) % 10000 + (num/1000);
	}
	
	public static int R(int num) {
		return  num / 10 + (num % 10) * 1000 ;
	}
}

class num{
	int num;
	String route="";

	public num(int num, String route) {
		this.num=num;
		this.route=route;
	}
}