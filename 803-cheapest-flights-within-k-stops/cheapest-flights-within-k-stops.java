class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            res.add((int)1e8);
        }
        res.set(src,0);

        

        for(int i=0;i<k+1;i++){
            ArrayList<Integer> temp = new ArrayList<>(res);
            for(int j=0;j<flights.length;j++){
                int s = flights[j][0];
                int d = flights[j][1];
                int wt = flights[j][2];

                if(res.get(s)!=(int)1e8 && res.get(s)+wt<temp.get(d)){
                    temp.set(d,res.get(s)+wt);
                }

            }
            res = temp;
        }
        if(res.get(dst) == (int)1e8){
            return -1;
        }
        return res.get(dst);


        
    }
} 