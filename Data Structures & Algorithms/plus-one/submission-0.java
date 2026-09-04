class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int carry = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] += carry;
                carry = 0;
                break;
            }
            digits[i] = 0;
        }
        if (carry == 0) {
            return digits;
        }
        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }
}
