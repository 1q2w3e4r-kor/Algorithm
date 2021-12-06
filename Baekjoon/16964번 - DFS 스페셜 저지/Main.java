import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static boolean visited[];
	static ArrayList<Integer> result;
	static boolean cor =true;
	static ArrayList<Integer>[] list;
	static int idx=1;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n + 1];
		for (int i = 1; i < n+1; i++) {
            list[i] = new ArrayList<>();
        }
		for(int i=0;i<n-1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			list[x].add(y);
			list[y].add(x);
		}
		visited = new boolean[n+1];
		result = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int size = st.countTokens();
		for(int i=0;i<size;i++) {
			result.add(Integer.parseInt(st.nextToken()));
		}
		visited[1]=true;
		dfs(1);
		if(cor) System.out.println(1);
		else System.out.println(0);
	}
	
	static void dfs(int x) {
		if (!cor) {
            return;
        }

        ArrayList<Integer> set = new ArrayList<>();
        for (int next : list[x]) {
            if (!visited[next]) {
                visited[next] = true;
                set.add(next);
            }
        }

        int size = set.size();
        for (int i = 0; i < size; i++) {
            if (set.remove(result.get(idx))) {
                dfs(result.get(idx++));
            } else {
                cor = false;
                return;
            }
        }
	}
}