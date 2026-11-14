class Solution {
    boolean bipartite = true;

    public void dfs(int[][] graph,int node,int c, int[] colors){
        colors[node]=c;

        for(int i=0;i<graph[node].length;i++){
            int neighbour = graph[node][i];

            if(colors[neighbour]!=-1 && colors[neighbour] == colors[node]){
                bipartite = false;

            }
            if(colors[neighbour] == -1){
                dfs(graph,neighbour,1-c,colors);
            }
        }
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        
    
        int[] colors = new int[n];
        for(int l=0;l<n;l++){
            colors[l]= -1;
        }

        

        

        for(int k=0;k<n;k++){
            if(colors[k] == -1){
                dfs(graph,k,0,colors);
            }

        }

        return bipartite;


        

        
        
    }
}