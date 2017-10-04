//DFS RECURSION
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
            return null;
        Map<Integer,UndirectedGraphNode> map = new HashMap<Integer,UndirectedGraphNode>();
        UndirectedGraphNode newNode = helper(node, map);
        return newNode;
    }
    
    private UndirectedGraphNode helper(UndirectedGraphNode node, Map<Integer,UndirectedGraphNode> map){
        if(map.containsKey(node.label))
            return map.get(node.label);
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node.label,newNode);
        for(UndirectedGraphNode n: node.neighbors){
            UndirectedGraphNode neighbor = helper(n,map);
            newNode.neighbors.add(neighbor);
        }
        return newNode;
    }
}

//BFS ITINERATION
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) 
            return null;
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>(); 
        map.put(node.label, newNode);
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode n = queue.poll();
            for (UndirectedGraphNode neighbor : n.neighbors) {
                if (!map.containsKey(neighbor.label)) {
                    map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    queue.add(neighbor);
                }
                map.get(n.label).neighbors.add(map.get(neighbor.label));
            }
        }
        return newNode;
    }
}
    