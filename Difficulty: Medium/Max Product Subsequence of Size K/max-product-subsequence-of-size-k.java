class Solution {
    public long maxProduct(int[] arr, int k) {
        long[] max = new long[k + 1];
        long[] min = new long[k + 1];

        for (int i = 0; i <= k; i++) {
            max[i] = Long.MIN_VALUE;
            min[i] = Long.MAX_VALUE;
        }

        max[0] = 1;
        min[0] = 1;

        for (int x : arr) {
            for (int j = k; j >= 1; j--) {
                long a = max[j];
                long b = max[j - 1] == Long.MIN_VALUE ? Long.MIN_VALUE : max[j - 1] * x;
                long c = min[j - 1] == Long.MAX_VALUE ? Long.MIN_VALUE : min[j - 1] * x;

                long d = min[j];
                long e = max[j - 1] == Long.MIN_VALUE ? Long.MAX_VALUE : max[j - 1] * x;
                long f = min[j - 1] == Long.MAX_VALUE ? Long.MAX_VALUE : min[j - 1] * x;

                max[j] = Math.max(a, Math.max(b, c));
                min[j] = Math.min(d, Math.min(e, f));
            }
        }

        return max[k];
    }
}