import java.util.HashMap;
import java.util.Scanner;

public class Main{
	static HashMap<Integer, Integer> map = new HashMap<>();
	static HashMap<Integer, Integer> visited = new HashMap<>();
	static HashMap<Integer, Integer> done = new HashMap<>();
	static int count=0;
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int[] arr = new int[input];
		for(int i=0;i<input;i++) {
			int cnt = sc.nextInt();
			
			for(int j=1;j<=cnt;j++) {
				map.put(j,sc.nextInt());
				visited.put(j,0);
				done.put(j,0);
			}
			
			for(int k=1;k<=cnt;k++) dfs(k);
			arr[i]=cnt-count;
			map.clear();
			visited.clear();
			done.clear();
			count=0;
		}
		for(int a:arr) System.out.println(a);
		sc.close();
	}
	
	public static void dfs(int idx) {
		if(visited.get(idx)==1) return;
		visited.put(idx, 1);
		int target = map.get(idx);
		
		if(visited.get(target)==0) dfs(target);
		else {
			if(done.get(target)!=1) {
				count++;
				for(int i =target;i != idx; i=map.get(i)) count++;
			}
		}
		done.put(idx, 1);
	}
}
