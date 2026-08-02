class Solution {
    public int func(int n){
        int sum=0;
        while(n>0){
            int lastdigit = n%10;
            n=n/10;
            sum= sum+lastdigit*lastdigit;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        int slow =n;
        int fast =n;
        while(fast!=1){
            slow = func(slow);
            fast = func(fast);
            fast = func(fast);
            if(slow==fast && slow!=1){
                return false;

            }
        }
        fast =1;
        return true;

        
    }
}