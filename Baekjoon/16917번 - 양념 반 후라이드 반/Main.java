import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a,b,c,x,y;
		long total=0;
		a = Integer.parseInt(st.nextToken());
		b=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken())*2;
		x=Integer.parseInt(st.nextToken());
		y=Integer.parseInt(st.nextToken());
		int min = Math.min(x, y);
		int allBan = Math.max(x,y)*c;
		if(c<a+b) {
			x-=min;
			y-=min;
			total=c*min;
		}else {
			while(x!=0&&y!=0) {
				x-=min;
				y-=min;
				total=(a+b)*min;
			}
		}
		if(x!=0) total+=(x*a);
		if(y!=0) total+=(y*b);
		total = Math.min(total, allBan);
		System.out.print(total);
	}
}