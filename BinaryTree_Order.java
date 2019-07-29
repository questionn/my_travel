//二叉树的前序遍历
    public void binaryTreePrevOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val+ " ");
        //左子树   因为一直是先进行打印，后一直先想左边走
        binaryTreePrevOrder(root.left);
        //右子树
        binaryTreePrevOrder(root.right);
    }

    //二叉树的中序遍历
    public void binaryTreeInOrder(Node root){
        if(root == null){
            return;
        }
        //先执行左子树到null
        binaryTreeInOrder(root.left);
        //左  中  右
        System.out.print(root.val+ " ");
        binaryTreeInOrder(root.right);
    }
    // 二叉树的后序遍历
    public void binaryTreePostOrder(Node root){
        if(root == null){
            return;
        }
        binaryTreePostOrder(root.left);
        //左  右  中
        //判断右子树
        binaryTreePostOrder(root.right);
        System.out.print(root.val+ " ");
    }