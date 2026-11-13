
class Solution {

    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;
        int time = 0;

        // Step 1: Find all rotten and fresh oranges
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {

                if(grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }

                if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int[] x = {-1, 1, 0, 0};
        int[] y = {0, 0, -1, 1};

        // Step 2: BFS
        while(!q.isEmpty() && fresh > 0) {

            int size = q.size();

            for(int k = 0; k < size; k++) {

                int[] curr = q.poll();

                int row = curr[0];
                int col = curr[1];

                for(int d = 0; d < 4; d++) {

                    int newRow = row + x[d];
                    int newCol = col + y[d];

                    if(newRow >= 0 && newRow < n &&
                       newCol >= 0 && newCol < m &&
                       grid[newRow][newCol] == 1) {

                        grid[newRow][newCol] = 2;
                        fresh--;

                        q.add(new int[]{newRow, newCol});
                    }
                }
            }

            time++;
        }

        if(fresh > 0) {
            return -1;
        }

        return time;
    }
}
