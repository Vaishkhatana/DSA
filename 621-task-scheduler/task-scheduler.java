class Solution {
    public int leastInterval(char[] tasks, int n) {
        int m = tasks.length;
        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Character,Integer> register = new HashMap<>();
        for(int i=0;i<m;i++){
            map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
            register.put(tasks[i],1);
        }

        class Pair{
            int first;
            char second;

            Pair(int f,char s){
                first = f;
                second = s;
            }
        }

        // max heap banana hai hammme .

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            if(a.first!=b.first){
                return b.first-a.first;
            }
            else{
                return b.second-a.second;
            }
        });

        for(Map.Entry<Character,Integer> e:map.entrySet()){
            char element = e.getKey();
            int freq = e.getValue();

            Pair curr = new Pair(freq,element);
            pq.add(curr);

        }
        int seat = 1;

        while(!pq.isEmpty()){
            ArrayList<Pair> list = new ArrayList<>();
            while(!pq.isEmpty()){
                Pair curr  = pq.peek();
                pq.poll();
                int freq = curr.first;
                char element = curr.second;

                if(register.get(element)<=seat){
                    if(freq>1){
                        pq.add(new Pair(freq-1,element));
                        register.put(element,seat+n+1);
                         
                    }
                    break;
                    

                }
                else{
                    list.add(curr);
                }
                
            }
            for(int i=0;i<list.size();i++){
                pq.add(list.get(i));
                
            }
            seat++;


        
            
        }
        return seat-1;

       


         
        
    }
}