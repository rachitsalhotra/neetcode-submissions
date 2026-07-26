class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        int[][] pairs = new int[n][2];

        for (int i = 0; i < n; i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }

        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

        double[] reachTimes = new double[n];

        for (int i = n - 1; i >= 0; i--) {
            double t = (double) (target - pairs[i][0]) / pairs[i][1];
            reachTimes[i] = t;
        }

        // System.out.println(Arrays.toString(reachTimes));

        int res = 1;
        double max = reachTimes[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (max < reachTimes[i]) {
                res++;
                max = reachTimes[i];
            }
        }

        return res;

        // System.out.println(Arrays.deepToString(pairs));

        // return -1;
    }
}
