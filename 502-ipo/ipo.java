class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] project = new int [n][2];
        for(int i=0;i<n;i++){
            project[i][0] = capital[i];
            project[i][1] = profits[i];
        }

        Arrays.sort(project,(a,b)-> Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int idx = 0;
        while(k-->0){
            while(idx<n){
                if(project[idx][0]>w){
                    break;
                }
                else{
                    pq.add(project[idx][1]);
                    idx++;

                }
            }

            if(pq.isEmpty()){
                return w;
            }
            else{
                int profit = pq.peek();
                pq.poll();
                w = w+profit;
            }
            
        }
        return w;


        
    }
}