/888公平的糖果交换
    public static int[] fairCandySwap(int[] A, int[] B){
        /**
         * 首先他们拥有总共的糖果数  Sa     Sb
         * 当A给B一个糖果大小为x时，他期待收到一个大小为y的糖果
         * Sa-x+y == Sb-y+x
         * y = (Sb-Sa+2x)/2
         * 所以当送出一个x时，B送出一个大小为(Sb-Sa+2x)/2的糖果
         *
         * 注：由于重复的糖果没有意义
         * 所以使用set集合
         */

        //1、求出A,B的糖果大小总和
        int Sa = 0;
        int Sb = 0;
        for (int flag:A) {
            Sa += flag;
        }
        for (int flag:B) {
            Sb += flag;
        }
        //将B放到set集合，以进行判断是否存在(Sb-Sa+2x)/2
        Set<Integer> set = new HashSet<>();
        int delta = (Sb-Sa)/2;
        for (int flag:B) {
            set.add(flag);
        }

        //判断B中是否包含(Sb-Sa+2x)/2
        for (int flag:A) {
            if(set.contains(flag+delta)){
                return new int[]{flag,(flag+delta)};
            }
        }
        return new int[]{};
    }