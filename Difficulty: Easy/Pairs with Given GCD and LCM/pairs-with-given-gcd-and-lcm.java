class Solution {
    public int pairCount(int x, int y) {
        // LCM must be divisible by GCD
        if (y % x != 0) {
            return 0;
        }

        int n = y / x;
        int count = 0;

        // iterate through all divisors of n
        for (int d = 1; (long)d * d <= n; d++) {
            if (n % d == 0) {
                int other = n / d;

                if (gcd(d, other) == 1) {
                    if (d == other) {
                        // only possible when n == 1 (d = other = 1)
                        count += 1;
                    } else {
                        // both (d, other) and (other, d) are valid ordered pairs
                        count += 2;
                    }
                }
            }
        }

        return count;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}