package com.tom.heap;

import java.util.Arrays;

public class MyHeap implements IHeap {
    //使用数组实现
    private int[] elem;
    //使用大小
    private int usedSize;
    //数组初始化大小
    private final int DEFAULT_SIZE=10;

    public MyHeap(){
        this.elem = new int[DEFAULT_SIZE];
        this.usedSize = 0;
    }

    //判断
    public boolean isFull(){
        if(this.usedSize == this.elem.length){
            return true;
        }
        return false;
    }
    //一次调整
    @Override
    public void AdjustDown(int root, int len) {
        //从哪个节点开始
        int parent = root;
        //左孩子
        int child = 2*parent + 1;
        //孩子下标小于len，代表还有子树
        while(child < len){
            //判断有没有右孩子
            if(child+1 < len && elem[child] < elem[child+1]){
                child++;
            }
            /**
             * 每次发生交换，会导致某一个子孩子有可能不为大根堆
             * parent = child;       child = parent*2 +1
             */
            //child保存的时最大值下标
            if(elem[child] > elem[parent]){
                //交换
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                //继续调整
                parent = child;
                child = parent*2+1;
            }else{
                break;
            }
        }
    }

    //初始化堆
    @Override
    public void initHeap(int[] array) {
        //初始化  变成elem    每个方法可以共用
        for (int i = 0; i < array.length; i++) {
            this.elem[i] = array[i];
            this.usedSize++;
        }
        //变成大根堆
        for (int i = (usedSize-1)/2 ; i >= 0; i--) {
            AdjustDown(i,usedSize);
        }
    }

    @Override
    public void AdjustUp(int child) {
        int parent = (child-1)/2;
        while (child > 0){
            if(elem[child] > elem [parent]){
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                //转移
                child = parent;
                parent = (child-1)/2;
            }else{
                break;
            }
        }
    }

    //插入元素
    @Override
    public void pushHeap(int item) {
        //判断空间大小
        if(isFull()){
            elem = Arrays.copyOf(this.elem,this.usedSize*2);
        }
        //将元素插入到最后一个位置      调用向上调整
        elem[usedSize] = item;
        usedSize++;
        //采用向上调整
        AdjustUp(usedSize-1);
    }

    //只删除堆顶元素
    @Override
    public int popHeap() {
        if(usedSize == 0){
            throw new UnsupportedOperationException("值为空");
        }
        //先交换
        int tmp = elem[0];
        elem[0] = elem[usedSize-1];
        elem[usedSize-1] = tmp;
        //保存
        int ret = elem[usedSize-1];
        //删除
        usedSize--;
        //进行向下调整
        AdjustDown(0,usedSize);

        return ret;
    }

    @Override
    public int getHeapTop() {
        if(usedSize == 0){
            throw new UnsupportedOperationException("值为空");
        }
        return elem[0];
    }

    //堆排
    @Override
    public void HeapSort() {
        /**
         * 1、先让堆变成一个大根堆
         * 2、每次将堆顶元素与最后一个元素--   进行交换  （保证每次出来都是最大）
         * 
         */
        int end = this.usedSize-1;
        while (end > 0){
            //最后一个--与堆顶进行交换
            int tmp = elem[end];
            elem[end] = elem[0];
            elem[0] = tmp;
            //
            AdjustDown(0,end);
            end--;
        }
    }

    @Override
    public void show() {
        for (int i = 0; i < usedSize ; i++) {
            System.out.print(elem[i]+" ");
        }
        System.out.println();
    }
}
