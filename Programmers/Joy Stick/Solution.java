import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {
		String name ="ABAAAAAAAAABB";
		System.out.println(solution(name));
	}
	
	public static int solution(String name) {
		int answer = 0;
		HashMap<Integer,String> word = new HashMap<>();
		HashMap<Integer,Integer> visited = new HashMap<>();
		for(int i=0;i<name.length();i++) {
			word.put(i, name.substring(i,i+1));
			visited.put(i,0);
		}
		int idx=0;
		int dir =1;
		int tmp=0;
		if(word.get(1).charAt(0)=='A')  dir = -1;
		while(visited.containsValue(0)) {
			if(idx == -1) idx=word.size()-1;
			else if(idx == word.size()) idx=0;
			int cnt=0;
			char ch = word.get(idx).charAt(0);
			if(idx != 0 && ch !='A') cnt=1;
			if(ch=='A') tmp+=1;
			else if(visited.get(idx)==0){
				if(tmp !=0) {
					cnt+=tmp;
					tmp=0;
				}
				if(ch>='O') 	cnt+='Z'-ch+1;
				else cnt += ch-'A';
			}else cnt=0;
			if(visited.get(0)==0 && ch=='A') tmp=0;
			visited.replace(idx, 1);
			
			int right=1,left=1;
			int i=idx+1;
			while(true) {
				if(i==word.size()) i=0;
				if(word.get(i).charAt(0)!='A' && visited.get(i)==0) break;
				else if(right>=word.size()) break;
				right++;
				i++;
			}
			i=idx-1;
			while(true) {
				if(i==-1) i=word.size()-1;
				if(word.get(i).charAt(0)!='A' && visited.get(i)==0) break;
				else if(left>=word.size()) break;
				left++;
				i--;
			}
			if(left>=right) dir=1;
			else dir=-1;
			idx+=dir;
			answer+=cnt;
			System.out.println(answer);
			
		}
        return answer;
    }
	
	
}
