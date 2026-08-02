class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int bestending = nums[0];
        int ans = nums[0];
        for(int i=1;i<n;i++){
            int value_1 = bestending+nums[i];
            int value_2 = nums[i];

            bestending = Math.max(value_1,value_2);
            ans = Math.max(ans,bestending);

            
        }
        return ans;
        
    }
}