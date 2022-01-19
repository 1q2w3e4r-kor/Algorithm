import java.io.*;

public class Main {
	static int n;
	static boolean visited[] = new boolean[1001];
	static int cnt = 0;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		one(0,0);
		System.out.print(cnt);
	}

	static public void one(int idx,int sum) {
		for(int i=0;i<=n;i++) {
			idx+=i;
			sum+=(i*1);
			five(idx,sum);
			idx-=i;
			sum-=(i*1);
		}
	}

	static public void five(int idx,int sum) {
		for(int i=0;i<=n-idx;i++) {
			idx+=i;
			sum+=(i*5);
			if(idx==n) {
				if(!visited[sum]) {
					visited[sum]=true;
					cnt++;
				}
			}else ten(idx,sum);
			idx-=i;
			sum-=(i*5);
		}
	}

	static public void ten(int idx,int sum) {
		for(int i=0;i<=n-idx;i++) {
			idx+=i;
			sum+=(i*10);
			if(idx==n) {
				if(!visited[sum]) {
					visited[sum]=true;
					cnt++;
				}
			}else fifty(idx,sum);
			idx-=i;
			sum-=(i*10);
		}
	}

	static public void fifty(int idx,int sum) {
		sum+=(n-idx)*50;
		if(!visited[sum]) {
			visited[sum]=true;
			cnt++;
		}
		sum-=(n-idx)*50;
	}
}