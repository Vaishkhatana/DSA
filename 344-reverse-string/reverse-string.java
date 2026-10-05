class Solution {
    public void reverseString(char[] s) {
        check(s,0,s.length-1);
    }

    public void check(char[] s , int low , int high){
        int len = high-low+1;
        if(len==0||len==1){
            return;
        }
        char temp = s[low];
        s[low] = s[high];
        s[high] = temp;

        check(s,low+1,high-1);
    }
}