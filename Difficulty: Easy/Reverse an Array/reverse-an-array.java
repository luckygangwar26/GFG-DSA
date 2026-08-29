class Solution {
	public void reverseArray(int arr[]) {
		int j = arr.length - 1;
		// code here
		for (int i = 0 ; i<arr.length/2; i++) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			j--;
		}
	}
}
