class Solution {
    public List<String> generateParenthesis(int n) {

        ArrayList<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        return check(0,0,n,sb,res);
    }

    public ArrayList<String> check(int open ,int close,int n, StringBuilder sb,  ArrayList res){
        if(open == n && close == n){
            res.add(sb.toString());
            return res;
        }

        if(open<n){
            sb.append('(');
            check(open+1,close,n,sb,res);
            sb.deleteCharAt(sb.length()-1);
        }

        if(close<open){
            sb.append(')');
            check(open,close+1,n,sb,res);
            sb.deleteCharAt(sb.length()-1);
        }
        return res;
    }
    

    
}