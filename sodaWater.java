package com.tom.dao;

import java.util.Scanner;

/**
 * Created with IDEA
 * <p>
 * author:Tom_Liu
 * <p>
 * Date:2019/5/20
 * <p>
 * Time:21:39
 */
public class Test {
    public static int waterCount(int n) {
        int fin = 0;
        while (n > 2) {
            int charge = n / 3;//换取几个
            fin += charge;
            int surplus = n % 3;//剩余
            int nextSum = charge + surplus;
            n = nextSum;
        }
        if (n == 2) {
            return fin+1;
        }
        return fin;
    }
    public static void main(String[] args) {
        System.out.println("Please input your soda water:");
        Scanner scanner = new Scanner(System.in);
        while( scanner.hasNextInt()) {
            int result = waterCount(scanner.nextInt());
            if(result == 0){
                break;
            }
            System.out.println("num of Exchange :" + result);
        }
    }
}
