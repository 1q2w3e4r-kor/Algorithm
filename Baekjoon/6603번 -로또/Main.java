import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static ArrayList<Integer> arr;
	static boolean[] visited;
	static StringBuffer sb;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if(n==0) break;
			arr = new ArrayList<>();
			for(int i=0;i<n;i++) arr.add(Integer.parseInt(st.nextToken()));
			visited = new boolean[n];
			sb = new StringBuffer();
			rec(0,-1,new ArrayList<String>());
			System.out.println(sb);
		}

	}

	public static void rec(int idx,int prev,ArrayList<String> list) {
		if(idx==6) {
			StringBuffer tmp = new StringBuffer();
			for(int i=0;i<6;i++) tmp.append(list.get(i));
			sb.append(tmp+"\n");
			return;
		}
		for(int i=prev+1;i<n;i++) {
			if(visited[i]) continue;
			visited[i] =true;
			list.add(arr.get(i)+" ");
			rec(idx+1,i,list);
			list.remove(idx);
			visited[i]=false;
		}
	}
}
