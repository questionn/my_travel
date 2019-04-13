package com.tom.dao;

import com.tom.impl.ILinkedT;

public class MySingListTImpl implements ILinkedT {

    class Node<T>{    //泛型类 节点
        private T value;
        private Node next;

        public Node(T value){
            this.value = value;
            this.next = null;
        }
    }

    private Node head;

    public MySingListTImpl(){
        this.head = null;
    }
    public Node findPre(int index) {               //寻找index前一个节点
        adjust(index);
        if(index == 0) {
            return null;
        }
        Node cur = this.head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        return cur;
    }
    public void adjust(int index){                 //判断index是否在范围内
        if(index<0 || index>this.getLength()) {
            throw new IndexOutOfBoundsException("下标越界");
        }
    }

    @Override
    public <T> void addFirst(T data) {             //头插
        Node<T> node = new Node<>(data);
        if(this.head == null){
            this.head = node;
        }else {
            node.next = this.head;
            this.head = node;
        }
    }

    @Override
    public <T> void addLast(T data) {              //尾插
        Node<T> node = new Node<>(data);
        Node<T> cur = this.head;
        if(this.head == null){
            this.head = node;
        }else{
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    @Override
    public <T> boolean addIndex(int index, T data) {            //指定位置插
        Node<T> node = new Node<>(data);
        Node<T> cur = findPre(index);
        if(cur == null){
           addFirst(index);
        }else {
            node.next = cur.next;
            cur.next = node;
        }
        return true;
    }

    @Override
    public <T> boolean contains(T key) {                //是否包含
        Node<T> cur = this.head;
        if(this.head == null)
            return false;
        while(cur != null){
            if(cur.value.equals(key)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public <T> int remove(T key) {                      //删除指定数据
        int count = 0;
        Node<T> cur = this.head;
        if(this.head == null)
            return -1;
        if(this.head.value.equals(key)) {
            this.head = head.next;
            return 0;
        }
        while(cur.next != null){
            if(cur.next.value.equals(key)){
                cur.next = cur.next.next;
                return count+1;
            }
            count++;
            cur = cur.next;
        }
        return -1;
    }

    @Override
    public <T> void removeAllKey(T key) {                      //删除所有指定数据
        if (this.head == null)
            throw new UnsupportedOperationException("不存在链表");
        Node<T> pre = null;
        Node<T> cur = this.head;
        while (cur != null) {
            if (cur.value.equals(key)) {
                pre.next = cur.next;
                cur = pre.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
    }


    @Override
    public int getLength() {                 //获取长度
        Node cur = this.head;
        int count = 0;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }

    @Override
    public void display() {                    //打印
        Node cur = this.head;
        while(cur != null){
            System.out.print(cur.value);
            if(cur.next != null) {
                System.out.print(",");
            }
            cur = cur.next;
        }

    }

    @Override
    public void clear() {              //清空
        Node cur = this.head.next;
        while (head.next != null) {
            Node flag = cur;
            head.next = cur.next;
            cur = cur.next;
            flag = null;
        }
        this.head = null;
    }
}
