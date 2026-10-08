class Solution {
    HashMap<Character,String> map = new HashMap<>();
    { map.put('2',"abc");
    map.put('3',"def");
    map.put('4',"ghi");
    map.put('5',"jkl");
    map.put('6',"mno");
    map.put('7',"pqrs");
    map.put('8',"tuv");
    map.put('9',"wxyz");

    }
    
    public List<String> letterCombinations(String digits) {
        
        StringBuilder diary = new StringBuilder();
        List<String> res = new ArrayList<>();

        check(digits,digits.length(),0,diary,res);
        return res;

        
    }

    public void check(String digits,int n , int idx,  StringBuilder diary, List<String> res){

        if(idx == n){
            res.add(diary.toString());
            return ;
        }

        String choices = map.get(digits.charAt(idx));

        for(int i=0 ;i<choices.length() ; i++){
            diary.append(choices.charAt(i));
            check(digits,n,idx+1,diary,res);
            diary.deleteCharAt(diary.length()-1);
        }
        
    }
}