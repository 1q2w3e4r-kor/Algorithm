import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {

		String numbers="333";
		System.out.println(solution(numbers));
		

	}

	public static int solution(String numbers) {
		int answer =0;
		String[] output = new String[numbers.length()];
        boolean[] visited = new boolean[numbers.length()];
		HashMap<Integer,Integer> map = new HashMap<>();
		String[] arr = numbers.split("");
		for(int i =1;i<=numbers.length();i++) {
			answer+=perm(arr,map,output,visited,0,numbers.length(),i);
		}
		return answer;
	}
	
	static int perm(String[] arr,HashMap<Integer,Integer> map, String[] output, boolean[] visited, int depth, int n, int r) {
		int cnt=0;
		if (depth == r) {
	    	String snum= "";
	        for(int i=0;i<r;i++) snum+=output[i];
	        int num=Integer.parseInt(snum);
	        if(!map.containsKey(num)) {
	        	if(num ==2||num==3) cnt=1;
	        	else {
			        for(int j=2;j*j<=num;j++) {
			        	if(num%j!=0) cnt=1;
			        	else {
			        		cnt=0;
			        		break;
			        	}
			        }
	        	}
	        }
	        if(cnt==1) map.put(num, 0);
	        return cnt;
	    }
	 
	    for (int i=0; i<n; i++) {
	        if (visited[i] != true) {
	            visited[i] = true;
	            output[depth]= arr[i];
	            cnt+=perm(arr,map, output, visited, depth + 1, n, r);
	            visited[i] = false;;
	        }
	    }
	    return cnt;
	}
}
