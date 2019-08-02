//二叉树的层序遍历
    public void binaryTreeLevelOrder(Node root){
        //使用队列
        //每次保存左右孩子
        Queue<Node> queue = new LinkedList<Node>();
        if(root != null){
            queue.offer(root);
        }

        while (!queue.isEmpty()){
            //出队
            Node cur = queue.poll();
            System.out.print(cur + " ");

            //左孩不为空
            if(cur.left != null){
                queue.offer(cur.left);
            }

            if(cur.right != null){
                queue.offer(cur.right);
            }
        }
    }