//编程实现全排列
    public static void fullPermutation(char[] A, int start ){
        //全排列采用递归的思想
        //先自己与自己交换
        //每次第一个与后面的没一个交换一次
        //第二个与后面的每次交换
        //第三个....
        //....

        //终止条件   基本条件
        if((A == null) || (start>A.length-1) || (start<0) ){
            return;
        }

        //终止条件   run指针到达最后
        if(start == A.length-1){  //代表没有可交换的元素
            System.out.print(new String(A) + " ");
        }

        //采用递归实现
        for (int run = start; run < A.length ; run++) {  //使得当start固定时，run不断+1，然后交换
                char tmp = A[run];
                A[run] = A[start];
                A[start] = tmp;
                //采用递归
                fullPermutation(A,start+1);
                //还原数组
                char tmp2 = A[run];
                A[run] = A[start];
                A[start] = tmp2;
        }
    }