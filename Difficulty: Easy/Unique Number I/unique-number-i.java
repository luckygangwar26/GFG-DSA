class Solution {
	public int findUnique(int[] arr) {
		int ans = 0;
		if (arr.length<2) {
			ans = arr[0];
		}
		else {
			for (int i = 0 ; i<arr.length; i++) {
				ans ^= arr[i];
			}
			
		}
		return ans;
		
	}
}
