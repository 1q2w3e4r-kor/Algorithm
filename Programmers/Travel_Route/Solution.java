import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {
		String[][] tickets= {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		for(String a:solution(tickets)) System.out.print(a+" ");
	}
	
	public static String[] solution(String[][] tickets) {
		HashMap<Integer,Integer> visited = new HashMap<>();
		ArrayList<String> arr = new ArrayList<>();
		for(int i=0;i<tickets.length;i++) visited.put(i, 0);
		
		ArrayList<String> tmp = new ArrayList<>();
		for(int i=0;i<tickets.length;i++) {
			if(tickets[i][0].equals("ICN")) {
				visited.replace(i, 1);
				dfs(tickets,visited,0,tickets[i]);
				visited.replace(i, 0);
				if(tmp== null) continue;
				else if(arr.isEmpty()) arr.addAll(tmp);
				else {
					for(int j=0;j<tmp.size();j++) {
						int comp =arr.get(j).compareTo(tmp.get(j));
						if(comp== -1) {
							arr.clear();
							arr.addAll(tmp);
							break;
						}else if(comp ==1) break;
					}
				}
			}
		}
		String[] answer = new String[arr.size()];
		for(int i =0;i<arr.size();i++) answer[i]=arr.get(i);
		return answer;
    }
	
	static ArrayList<String> dfs(String[][] tickets,HashMap<Integer,Integer> visited,int cnt,String[] cur) {
		ArrayList<String> arr = new ArrayList<>();
		
		if(cnt==tickets.length) {
			arr.add(cur[1]);
			return arr;
		}
		
		for(int i =0;i<tickets.length;i++) {
			if(tickets[i][0].equals(cur[0]) && visited.get(i)==0) {
				visited.replace(i, 1);
				ArrayList<String> tmp = new ArrayList<>();
				tmp= dfs(tickets,visited,cnt+1,tickets[i]);
				visited.replace(i, 0);
				if(tmp== null) continue;
				else if(arr.isEmpty()) arr.addAll(tmp);
				else {
					for(int j=0;j<tmp.size();j++) {
						int comp =arr.get(j).compareTo(tmp.get(j));
						if(comp== -1) {
							arr.clear();
							arr.addAll(tmp);
							break;
						}else if(comp ==1) break;
					}
				}
			}
		}
		return arr;
	}
}
