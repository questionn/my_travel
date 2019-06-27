  //快速排序
    public static void quickSort(int[] A, int low, int high){ //high 最后一个元素下标
        /**
         * 思想：将数组分成两部分进行进行排序
         *      然后取一个最左边的为的为基准，右边比它大的与左边比他小的交换
         *      当左右指针相等时，将其元素与基准元素交换，是的右边全是比基准大的数，左边全是比基准小的数
         */
        //判断条件
        if(low>=high){
            return ;
        }
        //定义变量
        int i = low;
        int j = high;
        int tmp = A[low];  //基准
        while(i<j){
            //先走右边
            while ((A[j] >= tmp && i<j)) {   //使得右边的全部为    大于等于基准的值
                j--;
            }
            while((A[i] <= tmp) && i<j ){  //使得左边全部为   小于等于基准的值
                i++;
            }
            //当两个while都不满足时    左边为大  右边为小
            //交换
            if(i<j){
                int ex = A[i];
                A[i] = A[j];
                A[j] = ex;
            }
        }
        //一次排序完成   基准左边小   右边大
        //是条件满足
        A[low] = A[i];
        A[i] = tmp;

        //递归使得完全有序   以刚才的i，j相等为中间
        quickSort(A,low,j-1);
        quickSort(A,j+1,high);
    }