class Solution {
    // helper function

    public long FindHours(int[] piles,  int guess ){
        long h= 0 ;
        for(int i = 0;i<piles.length;i++){
            h = h+(piles[i]/guess);
            if(piles[i]%guess!=0){
                h++;
            }
        }
        return h;

    }
    public int minEatingSpeed(int[] piles, int h) {
        int low =1;
        int res = -1;
        int high = piles[0];
        for(int i =1;i<piles.length;i++){
            if(piles[i]>high){
                high = piles[i];
            }
        }
        while(low<=high){
            int guess = (low+high)/2;

            long hours = FindHours(piles,guess);

            if(hours>h){
                low = guess+1;
            }
            else{
                res = guess;
                high = guess-1;
            }
            
        }
        return res;
        
    }
}