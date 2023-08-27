package DSA.Graph.DFS;

import java.util.ArrayList;
import java.util.List;

class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        Node[] visited = new Node[101];
        Node copy = new Node(node.val);
        visited[copy.val] = copy;
        DFS(node, copy, visited);
        return copy;
    }
    public void DFS(Node node, Node copy, Node[] visited){
        visited[copy.val] = copy;
        for(Node neighbor: node.neighbors){
            if(visited[neighbor.val] == null){
                Node newNode = new Node(neighbor.val);
                copy.neighbors.add(newNode);
                DFS(neighbor, newNode, visited);
            } else {
                 copy.neighbors.add(visited[neighbor.val]);
            }
        }
    }
}
