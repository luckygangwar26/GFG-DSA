class Solution {
    public int maxDiffSum(int[] arr) {
        int n = arr.length;

        long original = 0;
        long replaced = 0;

        for (int i = 1; i < n; i++) {
            long newOriginal = Math.max(
                original + Math.abs((long) arr[i] - arr[i - 1]),
                replaced + Math.abs((long) arr[i] - 1)
            );

            long newReplaced = Math.max(
                original + Math.abs(1L - arr[i - 1]),
                replaced
            );

            original = newOriginal;
            replaced = newReplaced;
        }

        return (int) Math.max(original, replaced);
    }
}