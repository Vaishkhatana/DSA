class Solution {
    public int removeDuplicates(int[] nums) {
        int start=0;
        int end =1;
        
        int unique_element =1;

        while(end<nums.length){
            if(nums[end]==nums[end-1]){
                end++;
                
            }
            else{
                nums[start+1]=nums[end];
                start++;
                end++;
                unique_element++;
            }
        }
        return unique_element;
        
    }
}