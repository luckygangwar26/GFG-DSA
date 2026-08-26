class Solution {
     int missingNum(int arr[]) {

         int n = arr.length + 1;
         int ans = n;

         for (int i = 0; i < arr.length; i++) {
             ans = ans ^ (i + 1) ^ arr[i];
         }

         return ans;
     }
 }