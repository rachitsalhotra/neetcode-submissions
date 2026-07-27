class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];
        
        int i = 0;
        for (; i < intervals.length; i++) {
            if (end < intervals[i][0]) {
                int[] ent = {start, end};
                res.add(ent);
                break;
            } else {
                if (start > intervals[i][1]) {
                    res.add(intervals[i]);
                    continue;
                }

                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
            }
        }

        if (i == intervals.length) {
            int[] ent = {start, end};
            res.add(ent);
        }

        while (i < intervals.length) {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[0][]);
    }
}
