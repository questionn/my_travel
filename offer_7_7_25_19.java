public class Solution {
    public int Fibonacci(int n) {
        if(n == 0 || n == 1){
            return n;
        }
        int longPre = 0;
        int pre = 1;
        int fin = 0;
        for (int i = 2; i <= n; i++) {
            fin = longPre + pre;
            longPre = pre;
            pre = fin;
        }
        return fin;
    }
}