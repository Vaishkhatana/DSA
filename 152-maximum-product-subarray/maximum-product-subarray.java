class Solution {
    public int maxProduct(int[] nums) {
        int n= nums.length;
        int maxending = nums[0];
        int minending = nums[0];
        int ans = nums[0];
        for(int i=1;i<n;i++){
            int value_1= maxending*nums[i];
            int value_2= minending*nums[i];
            int value_3= nums[i];

            maxending = Math.max(value_1,Math.max(value_2,value_3));
            minending = Math.min(value_1,Math.min(value_2,value_3));
            ans = Math.max(ans,Math.max(maxending,minending));


        }
        return ans;

        
    }
}