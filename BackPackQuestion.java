package com.tom.dynamic_programming;

public class BackpackQuestion {
    public static void backpackQuestionAct() {
        /**
         * 背包问题：
         *
         *  val[i] 当前价值   w[i] 当前重量     v[i][j]  表示在前i个物品中的最大价值
         *
         * 问题：给定背包大小，给定物品质量与价值，使得背包内存储尽可能大的价值
         *
         * 思想：
         *      使用建表的思想
         *
         * 1、根据需求建立一张二维数组  填表
         * 2、当v[i][0]  或 v[0][j] 等于0        因为没有商品，或者没有背包重量
         * 3、当w[i]>j  v[i][j] = v[i-1][j]      因为当前物品过大，所以存放上一个物品
         * 4、当w[i] <= j    max{v[i-1][j] , val[i] + val[i-1][j-w[i]}
         *
         * 1、建立一张存储表，用来记录如何存放商品的情况  path[][]
         * 2、当val[i] + val[i-1][j-w[i]大的时候，就path置为1
         * 注：v[i][j] = v[i-1][j];  //这里不需要record记录，因为他如果是最大的话，之前已经记录过
         *
         * 1、打印出path，指出由那些商品组成
         * 2、从后面开始找，如果找到，证明此物品已经被用，当前重量就除去这个 j -= w[i]
         *
         */
        int[] w = new int[]{1, 2, 3,2,2,4};//定义物品的重量
        int[] val = new int[]{1500, 3000, 2000,2000,3000,3000};//定义每个物品的价值

        int m = 5;  //背包的总容量
        int n = val.length;  //有几件物品

        //2、当填充完毕，需要使用一个二维数组，记录是那些物品组成的最大价值
        int[][] path = new int[n+1][m+1];

        //1、创建一张二维数组，使用填表的思想
        //有一行为0个物品，或0个重量
        int[][] v = new int[n + 1][m + 1];
        //0行      第一个条件
        for (int i = 0; i < v[0].length ; i++) {
            v[0][i] = 0;
        }
        //0列
        for (int i = 0; i < v.length ; i++) {
            v[i][0] = 0;
        }
        //填充中间部分
        for (int i = 1; i < v.length; i++) { //程序从1，开始
            for (int j = 0; j < v[0].length ; j++) {    //程序从1，开始
                //  第二个条件
                if(w[i-1] > j){   //i-1  是因为w中  第一个从0开始
                    v[i][j] = v[i-1][j];
                }else{     //w[i] =< j
                    /*v[i][j] = Math.max(v[i-1][j],val[i-1] +v[i-1][j-w[i-1]]);  //此时的中重量和价值从0开始*/
                    //2、存储最大值
                    if(v[i-1][j] < val[i-1] + v[i-1][j-w[i-1]]){
                        v[i][j] = val[i-1] + v[i-1][j-w[i-1]];
                        path[i][j] = 1;   //因为这里存放最大值
                    }else{
                        v[i][j] = v[i-1][j];  //这里不需要record记录，因为他如果是最大的话，之前已经记录过
                    }
                }
            }
        }


        //3、找出那些商品组成
        //从后面找，因为后面总是存储最大的
        int row = path.length -1;
        int col = path[0].length -1;
        while (row > 0 && col > 0){
            if(path[row][col] == 1){
                System.out.println("由" + row +"组成");
                //那么这个元素已经占据了空间
                //j-w[row-1]
                col = col -w[row-1]; //row指定的是哪个元素 从1开始的   所以-1
            }
            //换商品
            row--;
        }




        /*//打印二维数组  v[][]
        for (int i = 0; i < v.length ; i++) {
            for (int j = 0; j < v[0].length ; j++) {
                System.out.print(v[i][j] + "  ");
            }
            System.out.println();
        }*/
    }

    public static void main(String[] args) {
        backpackQuestionAct();
    }
}
