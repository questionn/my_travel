class Solution {
    public boolean isPalindrome(int x) {
        int flag = x;
        int rev =0;
        if(flag>0){
        while(flag>0){
            int temp =flag % 10;
            flag /= 10;
            if(rev>Integer.MAX_VALUE||rev == Integer.MAX_VALUE && temp>7)
                return false;
            rev = rev*10 + temp;
        }
    }
       if(rev == x){
           return true;
       }
        return false;
    }
}