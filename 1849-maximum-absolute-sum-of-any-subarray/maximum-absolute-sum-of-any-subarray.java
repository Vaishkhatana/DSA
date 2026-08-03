class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int maxending =nums[0];
        int minending =nums[0];
        int ans=Math.abs(nums[0]);

        for(int i=1;i<n;i++){
            int Value_1=maxending+nums[i];
            int Value_2=minending+nums[i];
            int Value_3=nums[i];

            maxending = Math.max(Value_1,Math.max(Value_2,Value_3));
            minending = Math.min(Value_1,Math.min(Value_2,Value_3));

            ans=Math.max(ans,Math.max(maxending,-minending));

            
        }
        return ans;
        
    }
}