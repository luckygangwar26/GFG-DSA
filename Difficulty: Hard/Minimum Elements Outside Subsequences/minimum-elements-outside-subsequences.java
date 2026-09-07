class Solution {
    public int minCount(int[] arr) {
        int n = arr.length;
        Integer[][][] dp = new Integer[n][n + 1][n + 1];

        return n - solve(0, -1, -1, arr, dp);
    }

    private int solve(int index, int inc, int dec, int[] arr, Integer[][][] dp) {
        if (index == arr.length) {
            return 0;
        }

        if (dp[index][inc + 1][dec + 1] != null) {
            return dp[index][inc + 1][dec + 1];
        }

        int skip = solve(index + 1, inc, dec, arr, dp);

        int takeInc = 0;
        if (inc == -1 || arr[index] > arr[inc]) {
            takeInc = 1 + solve(index + 1, index, dec, arr, dp);
        }

        int takeDec = 0;
        if (dec == -1 || arr[index] < arr[dec]) {
            takeDec = 1 + solve(index + 1, inc, index, arr, dp);
        }

        int selected = Math.max(skip, Math.max(takeInc, takeDec));

        return dp[index][inc + 1][dec + 1] = selected;
    }
}