class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int[] arr =new int[2];
        int n = nums.length;

        int low=0;
        int high=0;
        int res = Integer.MIN_VALUE;

        while(high<n){
            int k= high-low+1;
            arr[nums[high]]++;

            while(arr[1]<k){
                arr[nums[low]]--;
                low++;
                k= high-low+1;
            }
            int len= high-low+1;
            res= Math.max(res,len);
            high++;


        }
        return res;
        
    }
}