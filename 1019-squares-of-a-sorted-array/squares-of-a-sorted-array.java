class Solution {
    public int[] sortedSquares(int[] nums) {
        int n =nums.length;
        int[] numarr = new int[n];

        int start =0;
        int end = n-1;

        int x = n-1;

        while(start<=end){
            int ss = nums[start]*nums[start];
            int es = nums[end]*nums[end];

            if(ss>es){
                numarr[x] = ss;
                start++;
                x--;
            }
            else{
                numarr[x]=es;
                end--;
                x--;
            }


        }
        return numarr;
        
    }
}