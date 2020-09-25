import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CycleDetectionUnionFind {
    int nc, nr;
    int[] unionFind;
    char[][] grid;


    public boolean containsCycle(char[][] grid) {
        nr = grid.length;
        nc = grid[0].length;
        this.grid = grid;
        unionFind = new int[nr * nc];
        Arrays.fill(unionFind, -1);


        int id;
        boolean right, down;
        for(int row = 0; row < nr; row++){
            for(int col = 0; col < nc; col++){
                id = getID(row, col);
                right = checkEdge(row, col, row, col + 1);
                down = checkEdge(row, col, row + 1, col);
                if(right || down) return true;

            }
        }

        return false;
    }

    public boolean checkEdge(int row, int col, int orow, int ocol){
        if (orow >= nr || ocol >= nc) return false;
        char c = grid[row][col];
        char oc = grid[orow][ocol];

        if (c == oc){
            return union(getID(row, col), getID(orow, ocol));
        }
        return false;
    }

    public int find(int node){
        if (unionFind[node] == -1) return node;
        return find (unionFind[node]);
    }

    public boolean union(int n1, int n2){
        int p1 = find(n1);
        int p2 = find(n2);
        if (p1 == p2) return true;
        else{
            unionFind[p2] = p1;
            return false;
        }
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
        char[][] test10 = {{'b', 'b', 'b'},{'b', 'z', 'b'},{'b', 'b', 'b'},{'a', 'b', 'b'}};
        char[][] test11 = {{'b', 'b', 'b'},{'b', 'z', 'b'},{'b', 'z', 'b'},{'b', 'b', 'b'}};
        char[][] test9 = {{'a', 'b', 'b', 'e'},{'b', 'z', 'b', 'c'},{'b', 'b', 'a', 'a'}};
        char[][] test6 = {{},{},{}};
        char[][] test7 = {{'a'}};
        System.out.println(scratch.containsCycle(test8));
        System.out.println(scratch.containsCycle(test10));
        System.out.println(scratch.containsCycle(test11));
    }


}
