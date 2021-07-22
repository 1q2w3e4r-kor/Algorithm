import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
public class Solution {

	public static void main(String[] args) {
		String[] genres= {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 501, 800, 900};
		int[] answer=solution(genres,plays);
		for(int a:answer) {
			System.out.print(a+" ");
		}
	}
	
	public static int[] solution(String[] genres, int[] plays) {	
		HashMap <Integer,String> sortedGenres = new HashMap<>();
        HashMap <Integer,Integer> sortedPlays = new HashMap<>();
        HashMap <String,Integer> genresCount = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i =0;i<genres.length;i++) {
        	sortedGenres.put(i, genres[i]);
        	sortedPlays.put(i, plays[i]);
        	if(genresCount.containsKey(genres[i])) genresCount.replace(genres[i], genresCount.get(genres[i])+plays[i]);
        	else genresCount.put(genres[i], plays[i]);
        }
        List<Integer> rank = new ArrayList<>(sortedPlays.keySet());
        List<String> countRank = new ArrayList<>(genresCount.keySet());
        Collections.sort(rank, (value1, value2) -> (sortedPlays.get(value2).compareTo(sortedPlays.get(value1))));
        Collections.sort(countRank, (value1, value2) -> (genresCount.get(value2).compareTo(genresCount.get(value1))));
        int cnt;        
        for(String a:countRank) {
        	cnt=0;
        	for(int b: rank) {
        		if(cnt==2) break;
        		if(a.equals(sortedGenres.get(b))) {
        			arr.add(b);
        			cnt++;
        		}
        	}
        }
        int[] answer = new int[arr.size()];
        cnt=0;
        for(int a:arr) answer[cnt++]=a;
        return answer;
    }
}
