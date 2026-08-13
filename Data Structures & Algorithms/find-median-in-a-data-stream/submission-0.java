class MedianFinder {
    List<Integer> nums;

    public MedianFinder() {
        nums = new ArrayList<>();
    }
    
    public void addNum(int num) {
        int index = Collections.binarySearch(nums, num);
        if (index < 0) {
            index = - (index + 1);
        }
        while (index < nums.size()) {
            int temp = nums.get(index);
            nums.set(index, num);
            num = temp;
            index++;
        }
        nums.add(num);
    }
    
    public double findMedian() {
        if (nums.size() % 2 == 0) {
            return (nums.get(nums.size() / 2) + nums.get((nums.size() / 2) - 1)) / 2D;
        } else {
            return (double) nums.get(nums.size() / 2);
        }
    }
}
