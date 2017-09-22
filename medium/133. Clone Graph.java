public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;
        Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        return cloneGraphHelper(node, map);
    }
    
    private UndirectedGraphNode cloneGraphHelper(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map){
        if(map.containsKey(node.label)){
            return map.get(node.label);
        }   
        UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
        map.put(node.label, cloneNode);
        for(UndirectedGraphNode n: node.neighbors){
            if(map.containsKey(n.label))
                cloneNode.neighbors.add(map.get(n.label));
            else{
                UndirectedGraphNode neighbor = cloneGraphHelper(n, map);
                cloneNode.neighbors.add(neighbor);
            }
        }
        return cloneNode;
    }
}