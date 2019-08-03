package com.tom.divide_and_conquer;

public class HanoiTower {
    //汉诺塔的实现
    /**
     *
     * 思想：分治思想
     *
     * 步骤:
     * 如果只有一个盘 A -> C
     * 如果 n >= 2 我们总是可以看做是两盘，最下面的一个盘，最上面的盘（若干个）
     *
     *  1、先把最上面的盘  A -> B
     *  2、再把最下面的盘  A -> C
     *  3、再把B上的所有盘 B -> C
     *
     */

    //用两个盘子举例子，可以更好的理解
    public static void hanoiTowerAct(int num, char a, char b, char c){//盘子的数量，每一根柱子
        if(num == 1){
            System.out.println("第1个盘子从" + a + "-->" + c);
        }else {

            hanoiTowerAct(num - 1, a, c, b); // 不断地递归，当num==1   打印最上面的盘子到b盘
            //证明最上面的已经完成  //最下面的放到C
            System.out.println("第" + num + "盘子从" + a + "-->" + c);
            //最后把b放到C
            hanoiTowerAct(num-1,b,a,c);
        }

    }

    public static void main(String[] args) {
        hanoiTowerAct(5,'a','b','c');
    }
}
