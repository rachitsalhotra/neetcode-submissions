class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        boolean even = (n1 + n2) % 2 == 0;

        if (n1 == 0) {
            if (even) {
                return (nums2[n2 / 2] + nums2[(n2 / 2) - 1]) / 2D;
            } else {
                return nums2[n2 / 2];
            }
        }

        if (n2 == 0) {
            if (even) {
                return (nums1[n1 / 2] + nums1[(n1 / 2) - 1]) / 2D;
            } else {
                return nums1[n1 / 2];
            }
        }

        int partSize = (n1 + n2) / 2;

        int l = 0;
        int r = n1 - 1;

        while (l <= r) {
            int m = l + ((r - l) / 2);
            int sec = Math.min(n2, partSize - (m + 1));
            
            if (sec < 0) {
                r = m - 1;
                continue;
            }

            if (sec != (partSize - (m + 1))) {
                l = m + 1;
                continue;
            }

            if ((m >= 0 ? nums1[m] : Integer.MIN_VALUE) <= (sec < n2 ? nums2[sec] : Integer.MAX_VALUE) && (sec - 1 >= 0 ? nums2[sec - 1] : Integer.MIN_VALUE) <= (m + 1 < n1 ? nums1[m + 1] : Integer.MAX_VALUE)) {
                if (even) {
                    double res = (double) (Math.max((m >= 0 ? nums1[m] : Integer.MIN_VALUE), (sec - 1 >= 0 ? nums2[sec - 1] : Integer.MIN_VALUE)) + Math.min((sec < n2 ? nums2[sec] : Integer.MAX_VALUE), (m + 1 < n1 ? nums1[m + 1] : Integer.MAX_VALUE))) / 2;
                    return res;
                } else {
                    return (double) Math.min((sec < n2 ? nums2[sec] : Integer.MAX_VALUE), (m + 1 < n1 ? nums1[m + 1] : Integer.MAX_VALUE));
                }
            }

            if ((m >= 0 ? nums1[m] : Integer.MIN_VALUE) > (sec < n2 ? nums2[sec] : Integer.MAX_VALUE)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        if (even) {
            int num1 = nums2[partSize - 1];
            int num2 = partSize >= n2 ? nums1[0] : nums2[partSize];
            return (num1 + num2) / 2D;
        } else {
            return nums2[partSize];
        }
    }
}
