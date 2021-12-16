import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n =Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		int[][] result = new int[n][m];
		for(int i =0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i =0;i<n;i++) {
			for(int j=0;j<m;j++) {
				int cur =arr[i][j];
				if(i==0 && j==0) result[0][0] = arr[0][0];
				else if(i==0 && j!=0) result[i][j] = cur + result[i][j-1];
				else if(j==0 && i!=0) result[i][j] = cur + result[i-1][j];
				else{
					int r = cur + result[i][j-1];
					int d = cur + result[i-1][j];
					if(r>d) result[i][j] = r;
					else result[i][j] = d;
				}
			}
		}
		
		System.out.print(result[n-1][m-1]);
	}
}