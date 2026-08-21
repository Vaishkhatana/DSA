class Solution {
    public int maxNumberOfBalloons(String text) {
        int n= text.length();
        int res = Integer.MAX_VALUE;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            char ch  = text.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        HashMap<Character,Integer> map2 = new HashMap<>();
        map2.put('b',1);
        map2.put('a',1);
        map2.put('l',2);
        map2.put('o',2);
        map2.put('n',1);

        for(Map.Entry<Character,Integer> e:map2.entrySet()){
            char key = e.getKey();
            int value = e.getValue();

            int value2 = map.getOrDefault(key,0);

            int times = value2/value;
            res = Math.min(res,times);

            

        }
        return res;
        
    }
} 