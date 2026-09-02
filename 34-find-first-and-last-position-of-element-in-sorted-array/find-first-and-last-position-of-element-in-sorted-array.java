class Solution {

    public int findStarting(int[] nums , int target){
        int n = nums.length;
        int low =0;
        int high = n-1;
        int res = -1;
        while(low<=high){
            int guess = (low+high)/2;
            if(nums[guess]< target){
                low = guess+1;
            }
            else if(nums[guess]> target){
                high = guess-1;
            }
            else{
                res= guess;
                high = guess-1;
            }
            
        }
        return res;

    }

    public int findending(int[] nums , int target){
        int n = nums.length;
        int low =0;
        int high = n-1;
        int res = -1;
        while(low<=high){
            int guess = (low+high)/2;
            if(nums[guess]< target){
                low = guess+1;
            }
            else if(nums[guess]> target){
                high = guess-1;
            }
            else{
                res= guess;
                low = guess+1;
            }
            
        }
        return res;

    }


    public int[] searchRange(int[] nums, int target) {
        int starting = findStarting(nums,target);
        int ending = findending(nums,target);

        return new int[]{starting,ending};
        
    }
}