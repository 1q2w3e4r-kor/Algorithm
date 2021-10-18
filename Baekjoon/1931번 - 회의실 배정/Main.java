import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		ArrayList<int[]> arr = new ArrayList<>();
		for (int i = 0; i < input; i++) arr.add(new int[] { sc.nextInt(), sc.nextInt() });
		arr.sort(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) return o1[0] - o2[0];
				else return o1[1] - o2[1];
			}
		});
		int cnt=	0;
		int prev = 0;
		for (int i = 0; i < input; i++) {
			if(prev<=arr.get(i)[0]) {
				prev = arr.get(i)[1];
				cnt++;
			}
		}
		System.out.print(cnt);
		sc.close();
	}
}