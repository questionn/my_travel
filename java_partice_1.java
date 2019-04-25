package com.tom.test;


public class TestPattern {
    public static void main(String[] args) {

        int value = callSurvivalNumber(10);
        System.out.println(value);
    }
//快乐数

//首次出现三次的英文字母


    //报数
    public static int callSurvivalNumber(int count) {
        if(count <= 0){
            throw new IllegalArgumentException("count is not null");
        }
        boolean[] callNumber = new boolean[count];
        for (int i = 0; i < callNumber.length ; i++) {
            callNumber[i] = true;
        }

        int index=-1; //下标
        int current = 0;//当前报的数字
        int counter = 0;//当前退出的人数

        while(counter < callNumber.length-1){

            //记录下表
            index = (index+1) % callNumber.length;
            //报数
            if(!callNumber[index]){
                continue;
            }
            current = (current+1) % 3;
            //判断
            if(current == 0){
                counter++;
                callNumber[index] = false;
            }
        }
        for (int i = 0; i < callNumber.length; i++) {
            if(callNumber[i]){
                return i+1;
            }
        }
        throw new IllegalArgumentException("error");
    }

}







