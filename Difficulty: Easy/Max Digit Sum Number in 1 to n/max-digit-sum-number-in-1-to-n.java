class Solution {

    public int findMax(int num) {
        int ans = num;
        int mSum = digitSum(num);

        int p = 1;

        while (num > 0) {
            int dig = num % 10;

            if (dig > 0) {
                int candidate = (num - 1) * p + (p - 1);
                int sum = digitSum(candidate);

                if (sum > mSum || (sum == mSum && candidate > ans)) {
                    mSum = sum;
                    ans = candidate;
                }
            }

            num /= 10;
            p *= 10;
        }

        return ans;
    }

    private int digitSum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}