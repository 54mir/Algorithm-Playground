import java.util.*;

public class Graph {
    private class Node{
        int value;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node = " + value;
        }
    }

    Map<String, Node> nodes = new HashMap<>();
    Map<Node, ArrayList<Node>> adjacencyList = new HashMap<>();

    public boolean hasCycle(){
        Set<Node> all = new HashSet<>(nodes.values());

        Set<Node> visiting = new HashSet<>();
        Set<Node> visited = new HashSet<>();
        Map<Node, Node> parents = new HashMap<>();

        while (!all.isEmpty()){
            Node node = all.iterator().next();
            if (hasCycle(node, all, visiting, visited))
                return true;
        }

        return false;
    }

    private boolean hasCycle(Node node, Set<Node> all, Set<Node> visiting, Set<Node> visited){
        all.remove(node);
        visiting.add(node);

        for (Node neighbor : adjacencyList.get(node)){
            if (visited.contains(neighbor)) continue;

            if (visiting.contains(neighbor))
                return true;

            if (hasCycle(neighbor, all, visiting, visited))
                return true;
        }

        visiting.remove(node);
        visited.add(node);

        return false;
    }

}
