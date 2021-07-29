import java.util.ArrayList;
import java.util.Collections;
public class Solution {

	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		for(int a: solution(array,commands)) System.out.println(a+" ");
	}
	
	public static int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> tmp = new ArrayList<>();
        int[] answer= new int[commands.length];
        
        for(int i=0;i<commands.length;i++) {
        	tmp.clear();
        	for(int j=commands[i][0]-1;j<commands[i][1];j++) tmp.add(array[j]);
        	Collections.sort(tmp);
        	answer[i]=tmp.get(commands[i][2]-1);
        }
        return answer;
    }
}

