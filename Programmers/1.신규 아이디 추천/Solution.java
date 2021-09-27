
class Solution {
	public String solution(String new_id) {

		new_id = new_id.toLowerCase();

		new_id = new_id.replaceAll("[^a-z|0-9|\\-_.]", "");

		String tmp = new String();
		do {
			tmp = "";
			tmp = tmp.concat(new_id);
			new_id = new_id.replaceAll("[\\.]{2}", ".");
		} while (new_id.compareTo(tmp) != 0);
		
		new_id = new_id.replaceAll("^[\\.]|[\\.]$", "");
		
		StringBuffer id = new StringBuffer(new_id);
		if(new_id.length()<1) {
			id.append('a');
			new_id = id.toString();
		}

		if (id.length() >= 16)
			new_id = id.substring(0, 15);
		new_id = new_id.replaceAll("[\\.]$", "");
		id = new StringBuffer(new_id);

		if (new_id.length() <= 2) {
			while (id.length() != 3) {
				id.append(id.charAt(new_id.length() - 1));
			}
		}
		return id.toString();
	}
}
