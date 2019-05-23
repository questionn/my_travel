package com.tom.dao;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:每日一题,4,
 * User: Tom-Liu
 * Date: 2019/5/23
 * Time: 14:52
 */

//买苹果  6个 8个
/*思想：1、先买8个，如果可以return，没有6个的——>
           算6个可以买几个（不能全买八个，最少有一个6个）
           每次从1开始给6个每增加一个看是否成立，如果成立return，否则继续*/
public class Test4 {
    public static int buyApple(int n){
        if(n%2 != 0 && n<6){
            return -1;
        }
        if(n%8 == 0){
            return n/8;//全买8个的
        }else{
            int res3 = n/6;//看6个能买几个
            for (int i = 1; i <= res3; i++) {//每次增加一个，判断
                if((n-6*i)%8 == 0){
                    return (n-6*i)/8+i;
                }
            }
        }
        return -1;//不成立
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int res = buyApple(n);
        System.out.println(res);
    }

}

