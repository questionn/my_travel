//189. 旋转数组 解法一
    public static void rotate1(int[] nums, int k) {
        /**
         * 问题：将数组向右移动k位
         *   例：输入: [1,2,3,4,5,6,7] 和 k = 3
         *       输出: [5,6,7,1,2,3,4]
         *   要求：空间复杂度 O(1)
         */
        /**
         * 思想1:  使用每次移动一位   时间复杂度过高O(n^2)
         */
        for (int i = 0; i < k ; i++) {
            myMove(nums);
        }
    }
    public static void myMove(int[] nums){
        if(nums == null){
            throw new NullPointerException();
        }
        int tmp = nums[nums.length-1];
        for (int i = nums.length-1; i > 0 ; i--) {
            nums[i] = nums[i-1];
        }
        nums[0] = tmp;
    }
    //189 旋转数组  解法二
    public static void rotate2(int[] nums, int k){
        /**
         * 123  2
         * 思路：使用一个新的数组，将需要旋转的数组进行拷贝
         * 空间复杂度O(n)
         * 时间复杂度O(n)
         */
        int[] tmp = new int[nums.length];
        /*//k大小的数组进行拷贝
        int i = 0;
        for (i = 0; i < k ; i++) {
            tmp[i] = nums[nums.length-k+i];
        }
        //前面的数组
        for (int j = 0; j < nums.length-k ; j++) {
            tmp[i++] = nums[j];
        }*/
        //简便算法
        for (int i = 0; i < nums.length ; i++) {
            tmp[(i+k) % nums.length] = nums[i];
        }
        for (int j = 0; j < nums.length ; j++) {
            nums[j] = tmp[j];
        }
    }
    //189 旋转数组 解法三
    public static void rotate3(int[] nums, int k){
        /**
         * 思想:采用数组反转
         *      1234567  3
         *      1、先整体反转   7654321
         *      2、反转前三个   5674321
         *      3、反转后4个    5671234
         */
        myReserves(nums,0,nums.length-1);  //从哪里开始  到哪里结束
        myReserves(nums,0,k-1);
        myReserves(nums,k,nums.length-1);
    }
    public static void myReserves(int[] A, int start, int end){
        while(start < end){
            int tmp = A[start];
            A[start] = A[end];
            A[end] = tmp;
            start++;
            end--;
        }
    }