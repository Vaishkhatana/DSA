class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[2];
        int low=0;
        int high = 0;
        int res = Integer.MIN_VALUE;

        while(high<n){
            int a = nums[high];
            arr[a]++;

            while(arr[0]>k){
                int b= nums[low];
                arr[b]--;
                low++;

            }
            int len = (high-low)+1;
            res = Math.max(res,len);
            high++;

        }
        return  res;


        
    }
}