class Solution {
    private Set<Integer> visiting = new HashSet<>();
    private boolean dfs(HashMap<Integer, List<Integer>> prerequisitesMap, int key) {
        List<Integer> dependents = prerequisitesMap.get(key);
        if (dependents == null) {
            return true;
        }
        if (visiting.contains(key)) {
            return false;
        }
        visiting.add(key);
        for (int i = 0; i < dependents.size(); i++) {
            if (!dfs(prerequisitesMap, dependents.get(i))) {
                return false;
            }
        }
        visiting.remove(key);
        prerequisitesMap.remove(key);
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> prerequisitesMap = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> dependents = prerequisitesMap.getOrDefault(prerequisites[i][0], new ArrayList<>());
            dependents.add(prerequisites[i][1]);
            prerequisitesMap.put(prerequisites[i][0], dependents);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(prerequisitesMap, i)) {
                return false;
            }
        }
        return true;
    }
}
