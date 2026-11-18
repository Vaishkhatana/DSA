class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<times.length;i++){
            int src= times[i][0];
            int dest = times[i][1];
            int wt = times[i][2];

            adj.get(src).add(new Pair(dest,wt));
        }


        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)->{
                if(a.first!=b.first){
                    return a.first-b.first;
                }
                return a.second-b.second;
            }
        );

        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<=n;i++){
            res.add(Integer.MAX_VALUE);
        }

        res.set(k,0);
        pq.add(new Pair(0,k));

        while(!pq.isEmpty()){
            Pair p = pq.peek();
            pq.poll();

            int dist = p.first;
            int node = p.second;

            if(dist>res.get(node)){
                continue;
            }

            for(int i=0;i<adj.get(node).size();i++){
                int neighbour = adj.get(node).get(i).first;
                int weight = adj.get(node).get(i).second;

                if(dist+weight<res.get(neighbour)){
                    res.set(neighbour,dist+weight);
                    pq.add(new Pair(dist+weight,neighbour));

                }
            }
        }
        int max = Integer.MIN_VALUE;

        for(int i=1;i<res.size();i++){
            if(res.get(i)>max){
                max= res.get(i);
            }

        }

        if(max == Integer.MAX_VALUE){
            return -1;
        }
        return max;

        
    }
}