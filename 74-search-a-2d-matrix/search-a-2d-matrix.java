class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //rows
        int n = matrix.length;
        // columns
        int m = matrix[0].length;

        int low = 0;
        int high = (n*m)-1;
        while(low<=high){
            int guess = (low+high)/2;
            int row = guess/m;
            int column = guess%m;
            if(matrix[row][column]==target){
                return true;
            }
            if(matrix[row][column]<target){
                low = guess+1;
            }
            else{
                high = guess-1;
            }
            

        }
        return false;


    
        
    }
}