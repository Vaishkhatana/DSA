class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] arr = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        for(int i=n-2;i>=0;i--){
            st.push(nums[i]);
        }

        for(int i=n-1;i>=0;i--){
            while(!st.empty() && st.peek()<=nums[i]){
                st.pop();
            }
            if(st.empty()){
                arr[i]= -1;
            }
            else{
                arr[i] = st.peek();
            }
            st.push(nums[i]);

        }
        return arr;
        
        
        
    }
}