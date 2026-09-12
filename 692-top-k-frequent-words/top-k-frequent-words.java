class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        int n = words.length;
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            String word = words[i];
            map.put(word,map.getOrDefault(word,0)+1);
        }
        class Pair{
            int first;
            String second;

            Pair(int f , String s){

                first = f;
                second = s;
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)->{
                if(a.first!=b.first){

                    return a.first-b.first;
                }
                //max heap for word
                return b.second.compareTo(a.second);
                
                
            }
        );

        for(Map.Entry<String,Integer> e:map.entrySet()){
            String wordss = e.getKey();
            int freq = e.getValue();

            Pair current = new Pair(freq,wordss);
            if(pq.size()<k){
                pq.add(current);
            }
            else{
                if(current.first>pq.peek().first){
                    pq.poll();
                    pq.add(current);
                }
                else if(current.first == pq.peek().first){
                    if(current.second.compareTo(pq.peek().second)<0){
                        pq.poll();
                        pq.add(current);
                    }
                }
            }
        }
        ArrayList<String> result = new ArrayList();
        while(!pq.isEmpty()){
            result.add(pq.poll().second);
            
        }
        Collections.reverse(result);
        return result;
        
    }
}