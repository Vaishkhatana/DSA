class Solution {

    public int findSmallest(int[][] matrix, int n, int m, int guess){
        int row = n-1;
        int col = 0;
        int count = 0;

        while(row>=0 && col<m){
            if(matrix[row][col]<=guess){
                count = count+row+1;
                col++;

            }
            else{
                row--;
            }
        }
        return count;
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[n-1][m-1];
        int res = -1;

        while(low<=high){
            int guess = (low+high)/2;
            int helper = findSmallest(matrix,n,m,guess);
            if(helper>=k){
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