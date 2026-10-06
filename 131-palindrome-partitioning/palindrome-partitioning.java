class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        check(s, 0, new ArrayList<>(), ans);
        return ans;
    }

    public void check(String s, int index, List<String> list,
                      List<List<String>> ans) {

        if(index == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = index; i < s.length(); i++) {

            String str = s.substring(index, i + 1);

            if(palindrome(str)) {

                list.add(str);

                check(s, i + 1, list, ans);

                list.remove(list.size() - 1);
            }
        }
    }

    public boolean palindrome(String str) {

        int low = 0;
        int high = str.length() - 1;

        while(low < high) {

            if(str.charAt(low) != str.charAt(high)) {
                return false;
            }

            low++;
            high--;
        }

        return true;
    }
}