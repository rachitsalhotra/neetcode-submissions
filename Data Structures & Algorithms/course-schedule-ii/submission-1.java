public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> prereq = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            prereq.put(i, new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            prereq.get(p[0]).add(p[1]);
        }

        List<Integer> output = new ArrayList<>();
        Set<Integer> visit = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();

        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course, prereq, visit, cycle, output)) {
                return new int[0];
            }
        }

        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = output.get(i);
        }
        return result;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> prereq,
                        Set<Integer> visit, Set<Integer> cycle,
                        List<Integer> output) {

        if (cycle.contains(course)) {
            return false;
        }
        if (prereq.get(course) == null) {
            return true;
        }

        cycle.add(course);
        for (int pre : prereq.getOrDefault(course, Collections.emptyList())) {
            if (!dfs(pre, prereq, visit, cycle, output)) {
                return false;
            }
        }
        cycle.remove(course);
        prereq.remove(course);
        output.add(course);
        return true;
    }
}