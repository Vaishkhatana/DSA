class Solution {
    public int maximumSum(int[] arr) {
        int nopower=arr[0];
        int power =0;
        int ans = arr[0];

        for(int i=1;i<arr.length;i++){
            int V1 = arr[i];
            int V2 = nopower+arr[i];
            int V3 = power+arr[i];
            int V4 = nopower;

            ans=Math.max(ans,Math.max(Math.max(V1,V2),Math.max(V3,V4)));

            nopower=Math.max(V1,V2);
            power=Math.max(V3,V4);

        }
        return ans;
        
    }
}