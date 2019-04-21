import java.util.Stack;
class MyQueue {
    private Stack<Integer> temp1 = null;
    private Stack<Integer> temp2 = null;

    /** Initialize your data structure here. */
    public MyQueue() {            //使用两个栈
        temp1 = new Stack<>();
        temp2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {         //全部放到第一个
        temp1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {                 //第二个栈为空 ， 就将第一个栈的数据往第二个里面加
        if(empty()){
            throw new UnsupportedOperationException("栈为空");
        }
        if(temp2.empty()){
            while(!temp1.empty()){
                temp2.push(temp1.pop());
            }
        }
        return temp2.pop();            //不管是否为空，直接pop第二个栈
    }
    
    /** Get the front element. */
    public int peek() {              //使用栈的peek
        if(empty()){
            throw new UnsupportedOperationException("栈为空");
        }
        if(temp2.empty()){
            while(!temp1.empty()){
                temp2.push(temp1.pop());
            }
        }
        int data = temp2.peek() ;
        return data; 
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(temp1.empty() && temp2.empty()){
            return true;
        }
    return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */