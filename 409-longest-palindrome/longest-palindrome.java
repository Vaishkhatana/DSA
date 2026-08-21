class Solution {
    public int longestPalindrome(String s) {
        int res = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        boolean odd = false;


        for(Map.Entry<Character,Integer> e:map.entrySet()){
            int value = e.getValue();

            if(value%2==0){
                res = res+value;
            }
            else{
                res =  res+value-1;
                odd = true;
            }
        }
        if(odd==true){
            res = res+1;
        }
        return res;

        


        
    }
}