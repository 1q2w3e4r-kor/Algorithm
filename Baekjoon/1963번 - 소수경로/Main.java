import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		String[][] arr = new String[num][2];
		for(int i =0;i<num;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = st.nextToken();
			arr[i][1] = st.nextToken();
		}
		for(int i=0;i<num;i++) {
			Queue<Cur> q = new LinkedList<>();
			HashMap<String,Integer> map = new HashMap<>();
			q.add(new Cur(arr[i][0],0));
			map.put(arr[i][0], 0);
			boolean isC = false;
			while(!q.isEmpty()) {
				Cur cur = q.poll();
				String str = cur.str;
				if(str.compareTo(arr[i][1])==0) {
					System.out.println(cur.cnt);
					isC= true;
					break;
				}
				for(int k=0;k<4;k++) {
					for(int j=0;j<10;j++) {
						if(k==0 && j==0) continue;
						String nstr = str.substring(0,k)+Integer.toString(j)+str.substring(k+1,4);
						if(map.containsKey(nstr)) continue;
						else if(isP(nstr)) {
							map.put(nstr,0);
							q.add(new Cur(nstr,cur.cnt+1));
						}
					}
				}
			}
			if(!isC) System.out.println("Impossible");
		}
	}
	
	public static boolean isP(String snum) {
		int num = Integer.parseInt(snum);
		for(int i=2;i<=Math.sqrt(num);i++) {
			if(num%i==0) return false;
		}
		return true;
	}
}

class Cur{
	String str;
	int cnt;
	Cur(String str,int cnt){
		this.str=str;
		this.cnt=cnt;
	}
}