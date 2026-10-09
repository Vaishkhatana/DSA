class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res =  new ArrayList<>();
        ArrayList<Integer> diary  = new ArrayList<>();

        check(candidates,target,candidates.length,0,0, diary,res);
        return res;
        
    }

    public void check(int[] candidates, int target,int n , int idx , int sum,ArrayList<Integer> diary, List<List<Integer>> res){
        if(idx == n){
            if(sum == target){
                res.add(new ArrayList<>(diary));
                
            }
            return;
        }

        check(candidates,target,candidates.length,idx+1,sum, diary,res);

        if(candidates[idx]+sum<=target){
            diary.add(candidates[idx]);
            sum = sum+candidates[idx];
            check(candidates,target,candidates.length,idx,sum, diary,res);
            diary.remove(diary.size()-1);
            sum = sum-candidates[idx];
        }
        return;
    }
}