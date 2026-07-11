class Solution {
    
    boolean fn(ArrayList<ArrayList<Integer>> adj, int u, boolean[] visited, int desitnation) {

        if (u == desitnation) {
            return true;
        }
        visited[u] = true;
      
        for (int v : adj.get(u)) {
            if (!visited[v] &&  fn(adj, v, visited,desitnation)) {
             return true;
            }
        }
        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
       

    
        boolean[] visited = new boolean[adj.size()];
        Arrays.fill(visited, false);
       return fn(adj, source, visited,destination);
    }
}