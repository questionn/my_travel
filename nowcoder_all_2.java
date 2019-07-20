/**
         * 二维数组向右递增，，并且向下递增
         * 1 7 9
         * 2 8 10
         * 5 11 12
         */
        //判断大小
        /**
         * 从右上角开始判断
         * 当目标数大于时，x++
         * 当目标数小于时，y--
         */
        if(array == null && array.length < 0){
            return false;
        }
        //当出现越界就false
        int x = 0;
        int y = array[0].length-1;
        while(x<array.length && y>=0){
            if(target > array[x][y]){
                x++;
            }else if(target < array[x][y]){
                y--;
            }else
                return true;
        }
        return false;