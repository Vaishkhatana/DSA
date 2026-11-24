class Solution {
    HashMap<Integer,Integer> dp = new HashMap<>();
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        if(dp.containsKey(n)){
            return dp.get(n);
        }

        int ans = climbStairs(n-1);
        int ans2 = climbStairs(n-2);

        int answer = ans + ans2;
        dp.put(n,answer);
        return answer;

        
    }
}