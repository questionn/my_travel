 //48  顺时针打印二维数组
    public static int[] clockwisePrint(int[][] mat, int n, int m){
        /**
         * 思想：
         * 1 2 3 4
         * 5 6 7 8
         * 9 10 11 12
         * 1、从左上角为基准开始打印，每次以一个环（或者不成环）为数据打印
         * 条件：左上角都是（0,0） （1,1）  这样（start,start)
         *      情况 4行4列   3  ，4    4 ， 3
         *
         *      (start*2 < n || start*2 < m)
         *
         * 行数，长度不固定
         * 2、以基准开始打印
         * 第一行
         * 第一列    如果start  < 列数
         * 第二行    如果start < 行数   && start < 列数
         * 第二列    如果start < 行数
         *
         *
         *
         *
         *
         */
        //保存值
        List<Integer> list = new ArrayList<>();
        //判断
        if(n < 0 || m < 0){
            return null;
        }
        //初始化基准
        int start = 0;
        while(start*2 < n || start*2 < m){
            clockwiseAdd(mat,start,list);
            start++;
        }
        int[] retArray = new int[n*m];
        Iterator<Integer> iterator = list.iterator();
        int i = 0;
        while (iterator.hasNext()){
            int tmp = iterator.next();
            retArray[i++] = tmp;
        }
        return retArray;
    }
    public static void clockwiseAdd(int[][] mat, int start, List<Integer> list){
        //结束
        int endX = mat.length - 1 - start;
        int endY = mat[0].length - 1 - start;

        //打印第一行  ( 不包含边界值)
        for (int i = start; i <= endY ; i++) {
            list.add(mat[start][i]);
        }

        //第一右边第一列
        if(start < endX){
            for (int i = start+1; i <= endX  ; i++) {
                list.add(mat[i][endY]);
            }
        }

        //下边一行
        if(start < endX && start < endY){  //必须同时满足
            for (int i = endY-1; i >= start ; i--) {
                list.add(mat[endX][i]);
            }
        }

        //左边一列
        if(start < endX -1 && start <endY){  //形成一个环  首先start < endY  才有可能走到左下角
            //而且左下角已经别打印过了
            //所以start < endX -1
            for (int i = endX -1; i > start ; i--) {
                list.add(mat[i][start]);
            }
        }
    }