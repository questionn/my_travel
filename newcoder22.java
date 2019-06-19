package com.tom.dao;
import java.util.*;
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Test22_NaN {
        //将链表里面的值取出来并且反转
        public static int listNodeTranFormInteger (ListNode flag){
            //使用StringBuffer
            StringBuffer stringBuffer = new StringBuffer();
            ListNode head = flag;
            while (head != null) {
                stringBuffer.append(head.val);
                head = head.next;
            }
            return Integer.parseInt(stringBuffer.reverse().toString());
        }
        //方向放
        public static ListNode reverseIntegerInListNode ( int tmp){
            //新建一个链表,头的值为tmp的最后最后一项
            ListNode retList = new ListNode(tmp % 10);
            //判断长度
            int count = 1;
            int flag = tmp;
            while ((flag = flag / 10) != 0) {
                count++;
            }
            //放入数字
            tmp = tmp / 10;
            ListNode cur = retList;
            for (int i = 1; i < count; i++) {
                ListNode listNode = new ListNode(tmp % 10);
                tmp = tmp / 10;
                cur.next = listNode;
                cur = listNode;
            }
            //后面的放入
            return retList;
        }
        public ListNode plusAB (ListNode a, ListNode b){
            //将链表里面的数 存放到int里面   并且将数字反转StringBuffer
            int flag1 = listNodeTranFormInteger(a);
            int flag2 = listNodeTranFormInteger(b);
            int sum = flag1 + flag2;  //两数之和
            //将和放入到链表中，并且反向放入
            return reverseIntegerInListNode(sum);
        }
}

