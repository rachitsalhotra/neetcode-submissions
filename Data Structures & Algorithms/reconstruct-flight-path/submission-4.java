class Solution {
    private Set<String> visited = new HashSet<>();
    private void findItinerary(HashMap<String, List<String>> adj, String node, String parent, List<String> path) {
        path.add(node);
        if (!adj.containsKey(node)) {
            return;
        }
        if (visited.contains(node) && node.equals(parent)) {
            return;
        }
        visited.add(node);
        List<String> dests = adj.get(node);
        if (dests.size() > 1) {
            parent = node;
        }
        List<List<String>> paths = new ArrayList<>();
        while (!dests.isEmpty()) {
            List<String> addPath = new ArrayList<>();
            findItinerary(adj, dests.remove(0), parent, addPath);
            paths.add(addPath);
        }
        List<String> lastEntry = new ArrayList<>();
        for (List<String> p: paths) {
            if (!p.get(p.size() - 1).equals(node)) {
                lastEntry = p;
            } else {
                path.addAll(p);
            }
        }
        path.addAll(lastEntry);
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, List<String>> adj = new HashMap<>();
        for (List<String> ticket: tickets) {
            adj.computeIfAbsent(ticket.get(0), k -> new ArrayList<>()).add(ticket.get(1));
        }
        for (List<String> dests: adj.values()) {
            Collections.sort(dests);
        }
        List<String> res = new ArrayList<>();
        findItinerary(adj, "JFK", "JFK", res);
        return res;
    }
}
