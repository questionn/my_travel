import java.util.Stack;
class MinStack {

    /** initialize your data structure here. */
    public MinStack() {
    }
    
    
     Stack<Integer> stack = new Stack<Integer>();
     Stack<Integer> minstack = new Stack<Integer>();
    
    
    public void push(int x) {
        stack.push(x);
        if(minstack.empty()){
            minstack.push(x);
        }else{
            if(x <= minstack.peek()){
                //维持最小栈的最小值,也是栈的最小值
                minstack.push(x);
            }
        }
    }
    
public void pop() {
        if(!stack.empty()){
			int element = stack.pop();
            if(element ==  minstack.peek()){
                minstack.pop();
            }
        }
    }
    
    public int top() {
        if(stack.empty()){
            return -1;
        }else{
            return stack.peek();
        }
    }
    
     public int getMin() {
        if(stack.empty()){
            throw new UnsupportedOperationException("没有数据1");
        }else{
            return minstack.peek();
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */