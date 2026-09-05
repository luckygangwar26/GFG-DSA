class Solution {
    public int longestSubseq(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for (int num : arr) {
            int left = map.getOrDefault(num - 1, 0);
            int right = map.getOrDefault(num + 1, 0);

            int curr = Math.max(left, right) + 1;

            map.put(num, Math.max(map.getOrDefault(num, 0), curr));

            max = Math.max(max, curr);
        }

        return max;
    }
}