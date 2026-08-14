class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int n= firstList.length;
        int m= secondList.length;
        int i=0;
        int j=0;
        ArrayList<int[]> list = new ArrayList<>();
        while(i<n && j<m){
            int start1=firstList[i][0];
            int end1=firstList[i][1];
            int start2=secondList[j][0];
            int end2=secondList[j][1];

            if(start1<=start2){
                if(end1>=start2){
                    int a = Math.max(start1,start2);
                    int b = Math.min(end1,end2);
                    list.add(new int[]{a,b});
                }
            }
            else{
                if(end2>=start1){
                    int a = Math.max(start1,start2);
                    int b = Math.min(end1,end2);
                    list.add(new int[]{a,b});

                }
            }
            if(end1<=end2){
                i++;
            }
            else{
                j++;
            }
        }
        int [][] res = new int[list.size()][2];
        for(int k=0;k<list.size();k++){
            res[k]=list.get(k);
        }
        return res;


        
        
    }
}