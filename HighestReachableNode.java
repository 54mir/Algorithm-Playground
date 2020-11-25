//import java.util.*;
//
//public class HighestReachableNode {
//    Map<Integer, List<Integer>> graph = new HashMap<>();
//
//
//    public int[] highest(){
//        Queue<Integer> all = new LinkedList<>();
//        all.addAll(graph.keySet());
//        int[] result = new int[all.size()];
//
//        while (!all.isEmpty()){
//            highest(all.remove(), all, result);
//        }
//
//    }
//
//    private int highest(Integer u, Set all, Set visiting, int[] result){
//        if (graph.get(u).isEmpty())
//            return u;
//
//        int highest = u;
//        for (Integer i : graph.get(u)){
//            if(!visiting.contains(i)){
//                visiting.add(i);
//                highest = Math.max(highest(i, all, visiting), highest);
//            }
//        }
//
//        result[u] = highest;
//        all.remove(u);
//
//
//
//    }
//
//
//    public static void main(String[] args) {
//        HighestReachableNode G = new HighestReachableNode();
//
//        G.graph.put(1, Arrays.asList(5));
//        G.graph.put(2, Arrays.asList(1, 4));
//        G.graph.put(3, Arrays.asList());
//        G.graph.put(4, Arrays.asList(3, 8));
//        G.graph.put(5, Arrays.asList(1));
//        G.graph.put(6, Arrays.asList(7));
//        G.graph.put(7, Arrays.asList(6));
//        G.graph.put(8, Arrays.asList(4));
//        G.graph.put(9, Arrays.asList());
//        G.graph.put(10, Arrays.asList(1, 2));
//
//    }
//}
