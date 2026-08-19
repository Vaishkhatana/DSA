class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Object[]> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(st.empty()){
                st.push(new Object[]{s.charAt(i),1});
            }
            else if(s.charAt(i)==(char)st.peek()[0] && (int)st.peek()[1]==k-1){
                st.pop();
            }
            else if(s.charAt(i)==(char)st.peek()[0]){
                st.peek()[1] = (int) st.peek()[1] + 1;

            }
            else{
                st.push(new Object[]{s.charAt(i),1});

            }
        }
        StringBuilder ans = new StringBuilder();

        while (!st.empty()) {
            Object[] pair = st.pop();

            char ch = (char) pair[0];
            int count = (int) pair[1];

            for (int i = 0; i < count; i++) {
                ans.append(ch);
            }
        }

        return ans.reverse().toString();

        
    }
}