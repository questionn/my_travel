package com.structure.dao;

import com.structure.impl.ILinkImpl;
import org.omg.CORBA.UNKNOWN;

public class ILink implements ILinkImpl {
    private Node head;
    private int usedSize;
    //使用内部类事项
    class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
            this.next = null;
        }
    }
    //无头
    public ILink(){
        this.head = null;
        this.usedSize = 0;
    }

    //头插
    @Override
    public void addFirst(int data) {
        Node cur = new Node(data);
        if(head == null){
            head = cur;
        }else {
            cur.next = head;
            head = cur;
        }
        usedSize++;
    }

    @Override
    public void addLast(int data) {
        Node cur = new Node(data);
        if(head == null){
            head = cur;
        }else{
            Node tmp = head;
            while(tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = cur;
        }
        usedSize++;
    }

    @Override
    public boolean addIndex(int index, int data) {
        Node cur = new Node(data);
        if(index<0 && index>usedSize){
            throw new UnsupportedOperationException("插入位置异常");
        }
        //头插
        if(index == 0){
            addFirst(data);
            return true;
        }


        if(head == null){
            throw new UnsupportedOperationException("链表为空");
        }
        // 1 3 4 5 5
        int count = 1;
        Node tmp = head;
        while(count < index){
            tmp = tmp.next;
            count++;
        }
        cur.next = tmp.next;
        tmp.next = cur;
        usedSize++;
        return true;
    }

    @Override
    public boolean contains(int key) {
        if(head == null){
            throw new UnsupportedOperationException("链表为空");
        }
        Node tmp = head;
        while(tmp != null){
            if(tmp.value == key){
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

    @Override
    public int remove(int key) {
        if(head == null){
            throw new UnsupportedOperationException("链表为空");
        }

        if(head.value == key) {
            head = head.next;
            usedSize--;
            return key;
        }
        Node tmp = head;
        while( tmp != null && tmp.next != null ){
            if(tmp.next.value == key){
                tmp.next = tmp.next.next;
                usedSize--;
                return key;
            }
            tmp = tmp.next;
        }
        return -1;
    }

    @Override
    public void removeAllKey(int key) {
        if(head == null){
            throw new UnsupportedOperationException("链表为空");
        }
        while(head.value == key){
            head = head.next;
        }
        Node tmp = head;
        while(tmp != null && tmp.next != null){
            if(tmp.next.value == key){
                tmp.next = tmp.next.next;
            }else {
                tmp = tmp.next;
            }
        }
    }

    @Override
    public int getLength() {
        return usedSize;
    }

    @Override
    public void display() {
        if(head == null){
            throw new UnsupportedOperationException("链表为空");
        }
        Node tmp = head;
        while(tmp != null){
            System.out.print(tmp.value + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {
        if(head == null){
            return;
        }
        Node cur = head;
        Node pre = head.next;
        while(cur.next != null){
            cur.next = null;
            cur = pre;
            pre= pre.next;
        }
        cur = null;
        pre = null;
        head = null;
        System.out.println("链表为" + head);
    }
}
