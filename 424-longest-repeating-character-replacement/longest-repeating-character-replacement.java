class Solution {
    public int find(int[]arr){
        int maxfreq = Integer.MIN_VALUE;
        for(int i=0;i<256;i++){
            maxfreq = Math.max(maxfreq,arr[i]);
        }
        return maxfreq;
    }
    public int characterReplacement(String s, int k) {
        int[] arr = new int[256];
        int n= s.length();
        int low=0;
        int high =0;
        int res = Integer.MIN_VALUE;
        while(high<n){
            char ch = s.charAt(high);
            arr[ch]++;
            int len =(high-low)+1;
            int maxfreq = find(arr);
            int diff = len-maxfreq;

            while(diff>k){
                char c = s.charAt(low);
                arr[c]--;
                low++;
                maxfreq = find(arr);
                len = (high-low)+1;
                diff = len-maxfreq;
            }
            len = (high-low)+1;
            res = Math.max(res,len);

            high++;

        

        }
        return res;
        
    }
}