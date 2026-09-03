class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1) {
            if (seen.contains(n)) {
                return false;
            }
            int num = 0;
            seen.add(n);
            while (n > 0) {
                int rem = n % 10;
                num += (rem * rem);
                n = n / 10;
            }
            n = num;
        }
        return true;
    }
}
