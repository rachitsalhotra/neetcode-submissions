class Solution {
    private Set<String> visited = new HashSet<>();
    private void arrangeLexicographically(List<List<String>> paths) {
        Collections.sort(paths, (a, b) -> a.get(0).compareToIgnoreCase(b.get(0)));
    }
    private void findItinerary(HashMap<String, Queue<String>> adj, String node, String parent, List<String> path) {
        path.add(node);
        if (!adj.containsKey(node)) {
            return;
        }
        if (visited.contains(node) && node.equals(parent)) {
            return;
        }
        visited.add(node);
        Queue<String> dests = adj.get(node);
        if (dests.size() > 1) {
            parent = node;
        }
        List<List<String>> paths = new ArrayList<>();
        while (!dests.isEmpty()) {
            List<String> addPath = new ArrayList<>();
            findItinerary(adj, dests.poll(), parent, addPath);
            paths.add(addPath);
        }
        List<String> lastEntry = new ArrayList<>();
        List<List<String>> entries = new ArrayList<>();
        for (List<String> p: paths) {
            if (!p.get(p.size() - 1).equals(node)) {
                lastEntry = p;
            } else {
                entries.add(p);
            }
        }
        // arrangeLexicographically(entries);
        for (List<String> entry: entries) {
            path.addAll(entry);
        }
        path.addAll(lastEntry);
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, List<String>> adjUnsorted = new HashMap<>();
        for (List<String> ticket: tickets) {
            adjUnsorted.computeIfAbsent(ticket.get(0), k -> new ArrayList<>()).add(ticket.get(1));
        }
        HashMap<String, Queue<String>> adj = new HashMap<>();
        for (Map.Entry<String, List<String>> entry: adjUnsorted.entrySet()) {
            List<String> l = entry.getValue();
            Collections.sort(l);
            Queue<String> q = new LinkedList<>();
            for (String it: l) {
                q.add(it);
            }
            adj.put(entry.getKey(), q);
        }
        // System.out.println(adj);
        List<String> res = new ArrayList<>();
        findItinerary(adj, "JFK", "JFK", res);
        return res;
        // JFK - SFO, ATL
        // SFO - ATL
        // ATL - JFK, SFO
    }
}
