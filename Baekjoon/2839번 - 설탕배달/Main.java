import java.util.Scanner;

public class Main {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int kg =sc.nextInt();
		for(int i =0 ;i<=kg/3;i++) {
			int t = 3*i;
			kg-=t;
			if(kg%5==0 || kg==0) {
				int f = kg/5;
				System.out.print(i+f);
				break;
			}
			kg+=t;
			if(i==kg/3) System.out.print(-1);
		}
		sc.close();
	}
}