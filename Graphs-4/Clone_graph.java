//Q-133@LeetCode
class Solution {
    private HashMap<Node, Node> visited = new HashMap<>();
    public void dfs(Node node, HashSet<Node> vis) {
        vis.add(node);
        Node cloneNode = new Node(node.val);
        visited.put(node, cloneNode);
        for (Node neighbor : node.neighbors) {
            if (!visited.containsKey(neighbor)) {
                dfs(neighbor, vis);
            }
            cloneNode.neighbors.add(visited.get(neighbor));
        }
    }
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        HashSet<Node> vis = new HashSet<>();
        dfs(node, vis);
        return visited.get(node);
    }
}