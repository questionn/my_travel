import java.util.Stack;
import java.lang.*;
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
        if(stack1.empty()&& stack2.empty()){
            throw new UnsupportedOperationException("没有数据");
        }
    if(stack2.empty()){
        while(!stack1.empty()){
            Integer temp = stack1.pop();
            stack2.push(temp);
        }
    }
        Integer temp1 = stack2.pop();
        return temp1;
    }
}