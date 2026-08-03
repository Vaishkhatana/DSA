class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int totalsum=nums[0];
        int Maxending = nums[0];
        int Maxsum  = nums[0];

        int Minending = nums[0];
        int Minsum  = nums[0];

        for(int i=1;i<nums.length;i++){
            //Maximum sum

            int V1 = Maxending+nums[i];
            int V2= nums[i];

            Maxending = Math.max(V1,V2);
            Maxsum = Math.max(Maxsum,Maxending);

            //Minimum sum

            int V3 = Minending+nums[i];
            int V4= nums[i];

            Minending = Math.min(V3,V4);
            Minsum = Math.min(Minsum,Minending);



            //total sum
            totalsum =totalsum+nums[i];

           




            
        }
         //subtract minimum sum from total sum
        if(Maxsum < 0){
            return Maxsum;
        }


        int result = totalsum-Minsum;
        return Math.max(result,Maxsum);

         
        
    }
} 