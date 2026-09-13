class Solution {
    static int[] bfs(int src, ArrayList<ArrayList<Integer>> adj, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        int farthestNode = src;

        while (!q.isEmpty()) {
            int node = q.poll();
            if (dist[node] > dist[farthestNode]) 
                farthestNode = node;

            for (int neighbor : adj.get(node - 1)) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[node] + 1;
                    q.add(neighbor);
                }
            }
        }
        return new int[]{farthestNode, dist[farthestNode]};
    }

    public int partyHouse(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();

        if (n == 1) return 0;

        // Step 1: find one end of the diameter
        int u = bfs(1, adj, n)[0];

        // Step 2: find the other end and the diameter length
        int[] result = bfs(u, adj, n);
        int diameter = result[1];

        // Step 3: minimum eccentricity = ceil(diameter / 2)
        return (diameter + 1) / 2;
    }
}