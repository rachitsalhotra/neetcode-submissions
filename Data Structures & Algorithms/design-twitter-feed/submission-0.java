class Twitter {
    private HashMap<Integer, HashSet<Integer>> followMap;
    List<int[]> tweets;

    public Twitter() {
        followMap = new HashMap<>();
        tweets = new ArrayList<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.add(new int[] {userId, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        for (int i = tweets.size() - 1; i >= 0; i--) {
            if (feed.size() == 10) {
                break;
            }
            if (tweets.get(i)[0] == userId || this.followMap.getOrDefault(userId, new HashSet<>()).contains(tweets.get(i)[0])) {
                feed.add(tweets.get(i)[1]);
            }
        }
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        HashSet<Integer> followers = this.followMap.getOrDefault(followerId, new HashSet<>());
        followers.add(followeeId);
        this.followMap.put(followerId, followers);
    }
    
    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> followerSet = this.followMap.get(followerId);
        if (followerSet == null) {
            return;
        }
        followerSet.remove(followeeId);
    }
}
