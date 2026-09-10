class Solution {
	public int lastWordLen(String s) {
		
		int i = s.length() - 1;
		int ans = 0;
		
		while (i >= 0 && s.charAt(i) == ' ') {
			i--;
		}
		
		while (i >= 0 && s.charAt(i) != ' ') {
			ans++;
			i--;
		}
		
		return ans;
	}
}
