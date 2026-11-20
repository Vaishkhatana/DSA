class Pair{
    int first;
    int second;

    Pair(int first , int second){
        this.first = first;
        this.second = second;
    }
}



class Solution {
    int [] x = {-1,1,0,0};
    int [] y = {0,0,-1,1};

    public boolean valid(int i,int j,int m,int n){
        
        if(i<0||i>=m||j<0||j>=n){
            
            return false;
        }

        return true;
    }

    public boolean bfs(int[][] grid,int m , int n , int guess ){
        int [][] visited = new int[m][n];

        Queue<Pair> q = new LinkedList<>();
        if(guess<grid[0][0]){
            return false;
        }

        q.add(new Pair(0,0));
        visited[0][0] = 1;

        while(!q.isEmpty()){
            Pair p = q.peek();
            q.poll();

            int row = p.first;
            int col = p.second;
            if(row == m-1 && col == n-1){
                return true;
            }

            for(int k=0;k<4;k++){
                int neirow = row+x[k];
                int neicol = col+y[k];

                
                if(valid(neirow,neicol,m,n) == true && visited[neirow][neicol] == 0 && guess>=grid[neirow][neicol]){
                    q.add(new Pair(neirow , neicol ));
                    visited[neirow][neicol] = 1;

                }
            }
        }
        return false;
        

    }
    public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int low = grid[0][0];
        int high = grid[0][0];
        int res =0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]>high){
                    high=grid[i][j];
                }
            }
        }

        while(low<=high){
            int guess = (low+high)/2;

            if(bfs(grid,m,n,guess) == true){
                res = guess;
                high = guess-1;
            }
            else{
                low = guess+1;

            }
            
        }

        return res;
        
    }
}