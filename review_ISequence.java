package com.structure.dao;

import com.structure.impl.ISequenceImpl;

import java.util.Arrays;

public class ISequence implements ISequenceImpl {
    //使用数组实现
    private int[] iseque;
    private final static int ARRAY_LENGTH = 3;
    private int userSize;

    //初始化
    public ISequence(){
        this.iseque = new int[ARRAY_LENGTH];
        this.userSize = 0;
    }

    //判断
    public boolean isFull(){
        if(this.userSize == this.iseque.length){
            return true;
        }
        return false;
    }
    //在pos位置插入val
    public boolean add(int pos, int data) {
        if(pos<0 || pos > userSize){
            return false;
            //顺序表只能依次插入
        }
        //扩容
        if(isFull()){
            this.iseque = Arrays.copyOf(this.iseque,this.iseque.length*2);
        }
        //移动
        //1 3 5 3 5
        for (int i = userSize-1; i >= pos ; i--) {
            iseque[i+1] = iseque[i];
        }
        // //插入
        iseque[pos] = data;
        userSize++;
        return true;
    }

    //查找关键字key 找到返回key的下标，没有返回nu
    public Integer search(int key) {
        for (int i = 0; i < userSize; i++) {
            if(iseque[i] == key)
                return i;
        }
        return null;
    }

    public boolean contains(int key) {
        for (int i = 0; i < userSize; i++) {
            if(iseque[i] == key)
                return true;
        }
        return false;
    }

    //得到pos位置的值
    public Object getPos(int pos) {
        if(pos<0 || pos > userSize){
            throw new UnsupportedOperationException("输入错误");
            //顺序表只能依次插入
        }
        return iseque[pos];
    }

    //删除第一次出现的关键字key
    // 1 2 3 4 5
    public Object remove(int key) {
        int index = search(key);
        for (int i = index+1; i < userSize ; i++) {
            iseque[i-1] = iseque[i];
        }
        userSize--;
        return key;
    }

    public int size() {
        return userSize;
    }

    public void display() {
        for (int i = 0; i < userSize; i++) {
            System.out.print(iseque[i] + " ");
        }
        System.out.println();
    }

    public void clear() {
        userSize=0;
    }
}
