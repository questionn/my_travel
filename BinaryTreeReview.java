package com.structure.leetcode;

import java.util.*;

public class BinaryTreeReview {
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
          this.val = x;
      }
  }

  //二叉树的前序遍历（递归）
  List<Integer> list = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        //采用递归方式
        if(root == null){
            return new ArrayList<Integer>();
        }
        list.add(root.val);

        preorderTraversal(root.left);

        preorderTraversal(root.right);

        return list;
    }

    //二叉树的前序遍历 （非递归）
    public List<Integer> preorderTraversalNonR(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        //非递归实现   采用栈
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode cur = root;
        TreeNode tmp = null;
        while(cur != null || !stack.empty()){
            while(cur != null){
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            tmp = stack.pop();
            cur = tmp.right;
        }
        return list;
    }

    //二叉树的中序遍历（递归）
    List<Integer> list1 = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        //采用递归
        if(root == null){
            return new ArrayList<Integer>();
        }

        inorderTraversal(root.left);
        list1.add(root.val);
        inorderTraversal(root.right);

        return list1;
    }

    //二叉树的中序遍历（非递归）
    public List<Integer> inorderTraversalNonR(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        //采用非递归   采用栈
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode cur = root;
        TreeNode tmp = null;

        while(cur != null || !stack.empty()){
            while(cur != null){
                stack.add(cur);
                cur = cur.left;
            }
            tmp = stack.pop();
            list.add(tmp.val);
            cur = tmp.right;
        }
        return list;
    }

    //二叉树的后序遍历（递归）
    List<Integer> list3 = new ArrayList<Integer>();
    public List<Integer> postorderTraversal(TreeNode root) {
        //采用递归
        if(root == null){
            return new ArrayList<Integer>();
        }

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list3.add(root.val);

        return list3;
    }

    //二叉树的后序遍历（非递归）
    public List<Integer> postorderTraversalNonR(TreeNode root) {
        //非递归  采用栈
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode cur = root; //保存根
        TreeNode pre = null;//避免出现cur死循环
        while(cur != null || !stack.empty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            //不能打印根
            cur = stack.peek();
            //判断右子树是否为空
            if(cur.right == null || cur.right == pre){
                list.add(cur.val);
                stack.pop();
                //避免出现cur死循环
                pre = cur;
                cur = null;
            }else{
                cur = cur.right;
            }
        }
        return list;
    }

    //100、相同的树（递归）
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null && q != null || p != null && q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        //前序遍历思想
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    //572、判断一棵树是否是另一棵树的子树
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null || t == null){
            return false;
        }
        if(isSameTree(s,t))
            return true;

        //左右两边只要一个成立即可
        return isSubtree(s.left,t) || isSubtree(s.right,t);
    }

    //104、 二叉树的最大深度
    public int maxDepth(TreeNode root) {
        //最大深度为左子树或右子树
        if(root == null)
            return 0;
        int leftDepth = maxDepth(root.left)+1;
        int rightDepth = maxDepth(root.right)+1;

        return leftDepth > rightDepth ? leftDepth : rightDepth;
    }

    //110、平衡二叉树
    public boolean isBalanced(TreeNode root) {
        //先判断是否为平衡，在遍历每一个元素
        //使用最大深度
        if(root == null)
            return true;
        //判断左右子树是否为平衡
        if(Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1)
            return false;

        //前序遍历每一个数
        return isBalanced(root.left) && isBalanced(root.right);
    }

    //101、对称二叉树
    public boolean isSymmetricChild(TreeNode l, TreeNode r){
        if(l == null && r == null)
            return true;
        if(l != null && r ==null || l == null && r != null)
            return false;
        if(l.val != r.val)
            return false;

        return isSymmetricChild(l.left,r.right) && isSymmetricChild(l.right,r.left);

    }
    public boolean isSymmetric(TreeNode root) {
        //显然是分左右两个子树进行判断
        if(root == null)
            return true;

        return isSymmetricChild(root.left, root.right);
    }

    //使用字符串变为二叉树
    // ABC##DE#G##F###          #空树
    class TreeNodeChar{
        char val;
        TreeNodeChar left;
        TreeNodeChar right;

        public TreeNodeChar(char val){
            this.val = val;
        }
    }
    int i = 0;//判断字符串的使用
    public TreeNodeChar stringToCreate(String str){
        //因为使用前序遍历
        TreeNodeChar root = null;

        if(str.charAt(i) != '#'){
            root = new TreeNodeChar(str.charAt(i));
            i++;
            root.left = stringToCreate(str);
            root.right = stringToCreate(str);
        }else{
            i++;
        }
        return root;
    }

    //中序遍历
    public void binaryTreeInOrder(TreeNodeChar root){
        if(root == null){
            return;
        }
        binaryTreeInOrder(root.left);
        System.out.print(root.val + " ");
        binaryTreeInOrder(root.right);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        BinaryTreeReview binaryTreeReview = new BinaryTreeReview();
        while(scanner.hasNextLine()){
            String str = scanner.nextLine();
            TreeNodeChar root = binaryTreeReview.stringToCreate(str);
            binaryTreeReview.binaryTreeInOrder(root);
        }
    }











}
