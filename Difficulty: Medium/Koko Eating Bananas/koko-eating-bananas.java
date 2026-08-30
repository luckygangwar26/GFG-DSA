class Solution {
    public int kokoEat(int[] arr, int k) {
        int left = 1;
        int right = 0;

        for (int i = 0; i < arr.length; i++) {
            right = Math.max(right, arr[i]);

        }

        while (left <= right) {
            int a = left + (right - left) / 2;
            long hour = 0;

            for (int i = 0; i < arr.length; i++) {
                hour += (arr[i] + a - 1) / a;
            }
            if (hour <= k) {
                right = a - 1;
            } else {
                left = a + 1;
            }
        }
        return left;
        
    }
}
