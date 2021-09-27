import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {
		String begin="hit";
		String target="cog";
		String[] words= {"hot", "dot", "dog", "lot", "log", "cog"};
		System.out.println(solution(begin,target,words));
	}
	
	public static int solution(String begin, String target, String[] words) {
        HashMap<Integer,String> map = new HashMap<>();
        HashMap<Integer,Integer> visited = new HashMap<>();
        map.put(0, begin);
        visited.put(0, 1);
        for(int i=0;i<words.length;i++)	{
        	map.put(i+1,words[i]);
        	visited.put(i+1, 0);
        }
        return dfs(map,visited,0,target,0);
    }

	static int dfs(HashMap<Integer,String> map,HashMap<Integer,Integer> visited, int idx, String target,int count) {
		String cur = map.get(idx);
		int ret=0;
		if(cur.equals(target)) return count;
		for(int i=0;i<map.size();i++) {
			int cnt=0;
			String tmp =map.get(i);
			if(visited.get(i)==0) for(int j=0;j<cur.length();j++) if(tmp.charAt(j)!=cur.charAt(j)) cnt++;
			if(cnt==1) {
				visited.replace(i, 1);
				int retCount = dfs(map,visited,i, target,count+1);
				visited.replace(i,0);
				if(retCount == 0) continue;
				else if(ret ==0) ret = retCount;
				else if (ret> retCount) ret= retCount;
			}
		}
		return ret;
	}
}
