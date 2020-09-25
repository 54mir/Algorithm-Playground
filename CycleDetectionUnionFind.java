import java.util.HashSet;
import java.util.Set;

public class CycleDetectionUnionFind {
    int nc, nr;
    int[] unionFind;


    public boolean containsCycle(char[][] grid) {
        nr = grid.length;
        nc = grid[0].length;
        unionFind = new int[nr * nc];



        return false;
    }

    public int find(int node){
        if (unionFind[node] == -1) return node;
        return find (unionFind[node]);
    }

    public void union(int n1, int n2){
//        int
    }





    public int getID(int row, int col){
        return ((row * nc) + col);
    }

    public static void main(String[] args) {
        CycleDetectionUnionFind scratch = new CycleDetectionUnionFind();
        char[][] test1 = {{'a', 'b', 'b'},{'b', 'z', 'b'},{'b', 'b', 'a'}};
        char[][] test2 = {{'b', 'b', 'b'},{'b', 'z', 'b'},{'b', 'b', 'b'}};
        char[][] test3 = {{'a', 'a', 'b'},{'a', 'b', 'b'},{'z', 'b', 'b'}};
        char[][] test4 = {{'a', 'b', 'c'},{'d', 'e', 'f'},{'a', 'a', 'a'}};
        char[][] test5 = {{'a', 'b', 'b'},{'b', 'z', 'b'},{'b', 'b', 'a'}};
        char[][] test8 = {{'a', 'b', 'b'},{'b', 'z', 'b'},{'b', 'b', 'a'},{'a', 'b', 'b'}};
        char[][] test9 = {{'a', 'b', 'b', 'e'},{'b', 'z', 'b', 'c'},{'b', 'b', 'a', 'a'}};
        char[][] test6 = {{},{},{}};
        char[][] test7 = {{'a'}};
        System.out.println(scratch.containsCycle(test1));
    }


}
