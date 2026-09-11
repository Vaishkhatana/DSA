class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        class Pair{
            int first;
            int second;

            Pair(int f , int s){
                first = f;
                second = s;
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            if(a.first!=b.first){

                return a.first - b.first;

            }
            return a.second - b.second;

        });
        


        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            int element = e.getKey();
            int freq = e.getValue();
            
            Pair current = new Pair(freq,element);

            if(pq.size()<k){
                pq.add(current);
                continue;
            }
            else{
                if(current.first>pq.peek().first){
                    pq.poll();
                    pq.add(current);
                }
            }
            
        }
        int[] result = new int[k];

        int i=0;
        while(!pq.isEmpty()){
            result[i] = pq.poll().second;
            i++;
        }
        return result;
        
    }
}



