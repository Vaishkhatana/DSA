class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        ArrayList<Integer> temp = new ArrayList<>();
        return check( nums,nums.length,0,temp,res);
    }

    public List<List<Integer>> check(int[] nums , int n , int idx , ArrayList<Integer> temp , List<List<Integer>> res ){
        if(idx == n){
            res.add(new ArrayList<>(temp));
            return res;
        }

        check(nums,nums.length,idx+1,temp,res);

        temp.add(nums[idx]);
        check(nums,nums.length,idx+1,temp,res);
        temp.remove(temp.size() -1);


        return res;


    }
}