class Solution {
    public int maxFruits(ArrayList<Integer> arr, int m) {
        int n = arr.size();

        if (m >= n) {
            int sum = 0;
            for (int fruit : arr) {
                sum += fruit;
            }
            return sum;
        }

        int sum = 0;

        for (int i = 0; i < m; i++) {
            sum += arr.get(i);
        }

        int max = sum;

        for (int i = m; i < n + m; i++) {
            sum += arr.get(i % n);
            sum -= arr.get((i - m) % n);
            max = Math.max(max, sum);
        }

        return max;
    }
}