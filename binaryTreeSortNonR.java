 //二叉树的前序遍历
    public void binaryTreePrevOrderNonR(Node root){
        //使用栈
        Stack<Node> stack = new Stack<Node>();
        Node cur = root;
        Node top = null;

        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                System.out.print(cur.val);
                cur = cur.left;
            }
            top = stack.pop();
            cur = top.right;
        }
    }

    //二叉树的中序遍历非递归
    public void binaryTreeInOrderNonR(Node root){
        //使用栈
        Stack<Node> stack  = new Stack<Node>();
        Node cur = root;
        Node top = null;
        //cur ！= null  主要是还有右子树
        // !stack.empty()  主要是当cur为空  树还没有打印完
        while(cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            top = stack.pop();
            System.out.print(top.val + " ");
            cur = top.right;
        }
    }