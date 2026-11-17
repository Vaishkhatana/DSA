class Pair{
    int first;
    int second;
    Pair(int first,int second){
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
    public int orangesRotting(int[][] grid) {
        int fresh =0;
        int time=0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j));
                    grid[i][j]= -2;
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        while(!q.isEmpty() && fresh>0){
            time++;

            int rotten = q.size();
            while(rotten-->0){
                Pair p = q.peek();
                q.poll();
                int i = p.first;
                int j = p.second;
                for(int k=0;k<4;k++){
                    int row = i+x[k];
                    int col = j+y[k];

                    if( valid(row,col,m,n) == true && grid[row][col] == 1 ){
                        q.add(new Pair(row,col));
                        grid[row][col] = -2;
                        fresh--;
                    }
                }
            }
        }
        if(fresh>0){
            return -1;
        }
        return time;

        


        
    }
}