 public boolean IsPopOrder(int [] pushA,int [] popA){
        //入栈顺序是 1 2 3 4 5
        //出站顺序有可能为  4  5 3 2 1
        /**
         * 思想：
         *  A一直入栈，知道A等于B，代表这个元素出栈
         *  然后pop掉，  j++
         *  继续判断，此时栈为空   代表匹配
         *   否则不匹配
         *   
         */
        if(pushA == null && pushA.length == 0){
            return false;
        }
        //定义一个辅助栈
        Stack<Integer> stack = new Stack<>();
        //popA下标
        int index = 0;
        //遍历A的元素
        for (int i = 0; i < pushA.length ; i++) {
            stack.push(pushA[i]);
            while (!stack.empty() && stack.peek() == popA[index]){
                //代表相同
                stack.pop();
                index++;
            }
        }
        return stack.empty();
    }