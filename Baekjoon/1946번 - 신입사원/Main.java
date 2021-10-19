import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		for(int i =0;i<input;i++) {
			int num = Integer.parseInt(br.readLine());
			Integer[][] arr = new Integer[num][2];
			for(int j =0;j<num;j++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				arr[j][0]=Integer.parseInt(st.nextToken());
				arr[j][1]=Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr, new Comparator<Integer[]>() {
				public int compare(Integer[] o1, Integer[] o2) {
					return o1[0]-o2[0];
				}
			});
			int max=1;
			int prev=arr[0][1];
			for(int k =1;k<num;k++) {
				if(prev>arr[k][1]) {
					max++;
					prev =arr[k][1];
				}
			}
			System.out.println(max);
		}
	}
}
