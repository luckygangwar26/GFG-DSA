class Solution {
    public int searchInsertK(int arr[], int k) {
        // code here
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k) {
                ans = i;
            }
            else if(arr[i]<k){
                ans = i+1;
            }
        }
        return ans;
    }
};