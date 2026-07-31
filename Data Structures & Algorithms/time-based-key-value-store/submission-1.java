class TimeMap {
    HashMap<String, List<String>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<String> vals = timeMap.getOrDefault(key, new ArrayList<>());
        if (vals.size() == 0) {
            timeMap.put(key, vals);
        }
        vals.add(timestamp + "#" + value);
    }
    
    public String get(String key, int timestamp) {
        List<String> vals = timeMap.get(key);
        if (vals == null) {
            return "";
        }
        int t = Integer.parseInt(vals.get(0).split("#")[0]);
        if (t > timestamp) {
            return "";
        }

        int l = 0;
        int r = vals.size() - 1;
        int ans = 0;

        while (l <= r) {
            int mid = l + ((r - l) / 2);
            int t1 = Integer.parseInt(vals.get(l).split("#")[0]);
            int t2 = Integer.parseInt(vals.get(r).split("#")[0]);
            int t3 = Integer.parseInt(vals.get(mid).split("#")[0]);

            if (t3 > timestamp) {
                r = mid - 1;
            } else if (t3 < timestamp) {
                l = mid + 1;
                ans = mid;
            } else {
                return vals.get(mid).split("#")[1];
            }
        }

        return vals.get(ans).split("#")[1];
    }
}
