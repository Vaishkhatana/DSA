class Solution {
    public String reorganizeString(String s) {
        String res = "";
        int seat =0;
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        class Pair{
            int first;
            String second;

            Pair(int f , String s){
                first = f;
                second = s;

            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            if(a.first!=b.first){
                return b.first - a.first;
            }
            return b.second.compareTo(a.second);
        });

        for(Map.Entry<Character,Integer> e:map.entrySet()){
            String element = String.valueOf(e.getKey());
            int freq = e.getValue();

            Pair current = new Pair(freq,element);
            
                pq.add(current);
            

        }

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            if(seat ==0 || res.charAt(seat-1)!=p.second.charAt(0)){
                res = res+p.second;
                seat++;
                p.first--;

                if(p.first>0){
                    pq.add(p);
                }
            }
            else{
                if(pq.isEmpty()){
                    return "";
                }
                else{
                    Pair p2 = pq.poll();
                    res = res+p2.second;

                    seat++;
                    p2.first--;

                    if(p2.first>0){
                        pq.add(p2);
                    }
                    
                    

                }
                pq.add(p);
                
            }

        }
        return res;



        
    }
}