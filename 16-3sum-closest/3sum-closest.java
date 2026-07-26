class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n= nums.length;
        int res =0;
        int gap = Integer.MAX_VALUE;

        for(int i=0;i<n-2;i++){
            int start =i+1;
            int end =n-1;
            while(start<end){
                int sum = nums[i]+nums[start]+nums[end];
                if (sum==target){
                    res= sum;
                    start++;
                    end--;
                }
                else if(sum<target){
                    int diff = target -sum;
                    if(diff<gap){
                        gap= diff;
                        res =sum;
                    }
                    start++;



                }
                else{
                    int diff = sum-target;
                    if(diff<gap){
                        gap= diff;
                        res =sum;
                    }
                    end--;
                    
                }
                

            }
        }
        return res;
        
    }
}