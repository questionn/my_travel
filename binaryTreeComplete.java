   //判断一棵树是否是完全二叉树 返回0代表是完全二叉树
    public int binaryTreeComplete(Node root){
        //使用队列
        Queue<Node> queue = new LinkedList<Node>();
        if(root != null){
            queue.offer(root);
        }
        //使用层序遍历思想
        while (!queue.isEmpty()){

            Node cur = queue.poll();

            if(cur.left != null){
                queue.offer(cur.left);
                queue.offer(cur.right);
            }else{
                break;
            }
        }
        //判断
        while(!queue.isEmpty()){
            if(queue.poll() != null){
                return 1;
            }
        }
       return 0;
    }