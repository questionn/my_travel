 //节点的个数
    public int getSize(Node root){
        //使用前序遍历
        //使用左孩子个数 加 右孩子个数   加1
        if(root == null){
            return 0;
        }
        //直接返回
        return getSize(root.left) + getSize(root.right) + 1;
        //或
        //递归左子树
        /*int tmp = 0;
        int tmp2 = 0;
        tmp = getSize(root.left);
        tmp2 = getSize(root.right);
        sum = tmp+tmp2+1;

        return sum;*/
    }

    // 叶子结点个数
    public int getLeafSize(Node root){
        if(root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }

        return getLeafSize(root.left) + getLeafSize(root.right);
    }

    // 第 k 层结点个数
    //第一行为  1开始
    public int getKLevelSize(Node root, int k){
        if(k == 0){
            throw new UnsupportedOperationException("下标从1开始");
        }
        //使用中序遍历吧
        if(k == 1){
            return 1;
        }
        if(root == null){
            return 0;
        }
        return getKLevelSize(root.left,--k) + getKLevelSize(root.right,--k);
    }

    // 查找，依次在二叉树的 根、左子树、右子树 中查找 value，
    // 如果找到，返回结点，否则返回 null
    public Node find(Node root, int value){
        if(root == null){
            return null;
        }
        if(root.val == value){
            return root;
        }
        //先序遍历
        Node tmp = find(root.left,value);
        //左子树没有找到
        if(tmp == null){
            tmp = find(root.right,value);
        }
        return tmp;
    }

    //二叉树的高度
    public int height(Node root){
        //判断左右那个孩子大  返回那个
        if(root == null){
            return 0;
        }
        //简写
       /* return height(root.left) > height(root.right)?
                height(root.left) +1 :height(root.right)+1;*/
       //另一个
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return leftHeight>rightHeight ? leftHeight+1 : rightHeight+1;

    }