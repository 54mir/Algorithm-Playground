import java.util.HashMap;
import java.util.Map;

class MinCostTree {
    Map<Integer, Integer> memo = new HashMap<>();

    int dfs(int row, int col, int[][] costs){
        int nr = costs.length;
        int nc = costs[0].length;
        if (row >= nr)
            return 0;

        int id = row * nc + col;
        if (memo.containsKey(id))
            return memo.get(id);

        int result = Math.min(dfs(row + 1, (col + 1) % 3, costs), dfs(row + 1, (col + 2) % 3, costs)) + costs[row][col];
        memo.put(id, result);

        return result;


    }

    int findMinCost(int[][] costs){

        int firstTwo = Math.min(dfs(0, 0, costs), dfs(0, 1, costs));
        return Math.min(firstTwo, dfs(0, 2, costs));
    }

    public static void main(String[] args) {
        int[][] costs = {{1,2,3},{3,2,1},{1,8,5},{9,7,5},{1,2,3},{3,2,1},{1,8,5},{9,7,5},{1,2,3},{3,2,1},{1,8,5},{9,7,5}};
        MinCostTree scratch = new MinCostTree();
        System.out.println(scratch.findMinCost(costs));


    }
}