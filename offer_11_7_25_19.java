//二进制中1的位数
    public int numberOfOne(int n){
        /**
         * 思想：
         *  使用 n & （n-1)
         *  因为每次n-1,会将所有的二进制1，移到最低位
         *  通过&  将1干掉
         *
         */
        int count = 0;
        while(n != 0){
            count++;
            n = n & (n-1);
        }
        return count;
    }