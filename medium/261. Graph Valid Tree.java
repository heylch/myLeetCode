class Solution {
    
    // BFS
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n-1) 
            return false;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) 
            map.put(i, new HashSet<>());
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int top = queue.poll();
            if (set.contains(top)) 
                return false;
            for (int node : map.get(top)) {
                queue.add(node);
                map.get(node).remove(top);
            }
            set.add(top);
        }
        return set.size() == n;
    }
    
    //DFS
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n-1) 
            return false;
        if(n == 1 && edges.length==0)
            return true;
        boolean[] visited = new boolean[n];
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        for(int i=0; i < edges.length; i++){
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            if(map.containsKey(node1))
                map.get(node1).add(node2);
            else{
                Set<Integer> nodes = new HashSet<Integer>();
                nodes.add(node2);
                map.put(node1,nodes);
            }
            if(map.containsKey(node2))
                map.get(node2).add(node1);
            else{
                Set<Integer> nodes = new HashSet<Integer>();
                nodes.add(node1);
                map.put(node2,nodes);
            }
        }
        for(int i = 0; i < n; i++){
            if(visited[i] == false){
                boolean result = dfs(i, map, visited);
                if(result == false)
                    return false;
            }
        }
        return true;
    }
    private boolean dfs(int node, Map<Integer, Set<Integer>> map, boolean[] visited){
        if(!map.containsKey(node))
           return false;
        if(map.get(node).isEmpty())
            return true;
        if(visited[node])
            return false;
        Set<Integer> nodes = map.get(node);
        visited[node] = true;
        for(Integer n: nodes){
            map.get(n).remove(node);
            if(dfs(n,map,visited) == false)
                return false;
        }
        return true;
    }
    
    //Union-Find
    public boolean validTree(int n, int[][] edges) {
        // initialize n isolated islands
        int[] nums = new int[n];
        Arrays.fill(nums, -1);
        
        // perform union find
        for (int i = 0; i < edges.length; i++) {
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);
            // if two vertices happen to be in the same set
            // then there's a cycle
            if (x == y) return false;
            // union
            nums[x] = y;
        }
        return edges.length == n - 1;
    }
    
    int find(int nums[], int i) {
        if (nums[i] == -1) return i;
        return find(nums, nums[i]);
    }
}