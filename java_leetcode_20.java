class Solution {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int top =0;
        
        //循环字符串 是每个括号进入判断
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stack[top] = s.charAt(i); //左括号入栈
                top++;
            }else{                        //右括号与栈中元素进行判断
                if(top == 0)              //为空
                    return false;
                else  if(s.charAt(i) == ')' && stack[top-1] == '(' || s.charAt(i) == '}'
                     && stack[top-1] == '{' || s.charAt(i) == ']' && stack[top-1] == '['){
                        --top;             //相等
                        continue;
                    }else{
                        return false;
                    }
                }
            }
        if(top >0){  //左边多
            return false;
        }
            return true;
        }
    }