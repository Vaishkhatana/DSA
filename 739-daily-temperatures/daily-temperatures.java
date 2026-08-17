class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n= temperatures.length;
        int [] arr = new int[n];
        arr[n-1]=0;
        Stack<Integer> st = new Stack<>();
        st.push(n-1);
        for(int i=n-2;i>=0;i--){
            while(!st.empty() && temperatures[st.peek()]<=temperatures[i]){
                st.pop();
            }
            if(st.empty()){
                arr[i] = 0;
            }
            else{
                int len=st.peek() - i;
                arr[i] = len;


            }
            st.push(i);
        }
        return arr;
        
        
    }
}