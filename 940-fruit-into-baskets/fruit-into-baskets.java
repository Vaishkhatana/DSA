class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = fruits.length;
        int low=0;
        int high = 0;

        int res = Integer.MIN_VALUE;

        while(high<n){
            map.put(fruits[high],map.getOrDefault(fruits[high],0)+1);

            while(map.size()>2){
                map.put(fruits[low],map.get(fruits[low])-1);
                if(map.get(fruits[low])==0){
                    map.remove(fruits[low]);
                }
                low++;
                

            }
            int len = (high-low)+1;
            res = Math.max(res,len);
        
            high++;
        }
        return res;
        
        
    }
   
}