class Solution {
    public int[] singleNum(int[] arr) {

        int xor = 0;

        // Step 1: All elements ka XOR
        for (int i = 0; i < arr.length; i++) {
            xor = xor ^ arr[i];
        }

        // Step 2: Rightmost different bit ka mask
        int mask = xor & (-xor);

        int num1 = 0;
        int num2 = 0;

        // Step 3: Elements ko 2 groups mein divide karo
        for (int i = 0; i < arr.length; i++) {

            if ((arr[i] & mask) != 0) {
                num1 = num1 ^ arr[i];
            } else {
                num2 = num2 ^ arr[i];
            }
        }

        // Step 4: Increasing order
        if (num1 > num2) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }

        return new int[]{num1, num2};
    }
}