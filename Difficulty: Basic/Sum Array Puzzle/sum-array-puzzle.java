class Solution {
	public void sumArray(int[] arr) {
		int sum = 0;
		for (int i = 0 ; i < arr.length ; i++) {
			sum += arr[i];
		}
		for (int j = 0 ; j<arr.length; j++) {
			arr[j] = sum - arr[j];
		}
	
	}
}
