class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int n= ransomNote.length();
        int m = magazine.length();
        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        for(int i=0;i<n;i++){
            char ch = ransomNote.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for(int j=0;j<m;j++){
            char chh = magazine.charAt(j);
            map2.put(chh,map2.getOrDefault(chh,0)+1);
        }

        for(Map.Entry<Character,Integer>e:map.entrySet()){
            char key = e.getKey();
            int value  = e.getValue();

            if(!map2.containsKey(key)){
                return false;
            }
            if(value>map2.get(key)){
                return false;
            }
        }

        return true;








    
        
    }
}