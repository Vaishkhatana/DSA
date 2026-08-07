class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int n = nums.length;
        int sum=0;
        int res=0;
        for(int i=0;i<n;i++){
            sum = sum+nums[i];
            int ques = sum%k;
            if(ques<0){
                ques = ques+k;
            }
            int freq =map.getOrDefault(ques,0);

            res = res+freq;
            map.put(ques,map.getOrDefault(ques,0)+1);

        }
        return res;
        
    }
}