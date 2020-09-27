import java.util.HashSet;
import java.util.Set;

public class CycleDetectionDFS {
        int nr, nc;
        char[][] grid;
        Set<Integer> visited = new HashSet<Integer>();

        public boolean containsCycle(char[][] grid) {
            this.grid = grid;
            nr = grid.length;
            nc = grid[0].length;
            int[] edgeList = new int[nr * nc - 1];

            int id;
            boolean result;
            for (int row = 0; row < nr; row++){
                for (int col = 0; col < nr; col++){
                    id = getID(row, col);
                    if(!visited.contains(id)){
                        result = dfs(row, col, grid, grid[row][col], -1);
                        if (result)
                            return true;
                    }
                }
            }
            return false;
        }

        public boolean dfs(int row, int col, char[][] grid, char c, int parent){
            int id = getID(row, col);
            if (row < 0 || row >= nr || col < 0 || col >= nc || grid[row][col] != c){
                return false;
            }

            if (visited.contains(id)) return true;
            visited.add(id);

            boolean result;
            if(getID(row - 1, col) != parent){
                result = dfs(row - 1, col, grid, grid[row][col], id);
                if (result) return result;
            }
            if(getID(row + 1, col) != parent){
                result = dfs(row + 1, col, grid, grid[row][col], id);
                if (result) return result;
            }
            if(getID(row, col - 1) != parent){
                result = dfs(row, col - 1, grid, grid[row][col], id);
                if (result) return result;
            }
            if(getID(row, col + 1) != parent){
                result = dfs(row, col + 1, grid, grid[row][col], id);
                if (result) return result;
            }
            return false;
        }

        public int getID(int row, int col){
            return ((row * nc) + col);
        }

        public static void main(String[] args) {
            CycleDetectionDFS scratch = new CycleDetectionDFS();
            char[][] test1 = {{'a', 'b', 'b'},{'b', 'z', 'b'},{'b', 'b', 'a'}};
            System.out.println(scratch.containsCycle(test1));
        }


}
