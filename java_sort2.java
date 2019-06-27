 //二分归并排序
    public static int[] mergeSort(int[] A, int left, int right){ //right就是最后一个元素下标
        /**
         * 思想：
         * 不断地进行二分的向下划分
         * 新的数组tmp。保存他们的顺序排列值，使用完直接赋值给原来的数组
         *
         */

        int mid = (left+right)/2;  //奇数为中间值，偶数为左边最后一个
        if(left<right){
            mergeSort(A,left,mid);  //左边划分
            mergeSort(A,mid+1,right);   //右边划分
            merge(A,left,mid,right);  //将划分的子问题  合并成一个有序的序列
        }
        return A;
    }
    public static void merge(int[] A, int left, int mid, int right){
        //1、创建一个新的数组。来保存当前的有序数组
        int[] tmp = new int[right-left+1];
        //将此时的左边和右边，进行排序
        int i = left;
        int j = mid+1;
        int run = 0; //负责跑动的指针
        //普通情况
        while((i<= mid) && (j<=right)){
            if(A[i] < A[j]){
                tmp[run++] = A[i++];
            }else{
                tmp[run++] = A[j++];
            }
        }
        //特殊情况  跳出while循环的可能
        //1、左边使用完毕   右边没有
        while(j<=right){
            tmp[run++] = A[j++];
        }
        //2、右边使用完毕，左边没哟
        while(i<mid+1){
            tmp[run++] = A[i++];
        }

        //此时数组已经是有序，将数组覆盖到原来数组
        for (int k = 0; k < tmp.length; k++) {
            A[k+left] = tmp[k];
        }
    }