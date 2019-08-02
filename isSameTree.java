//相同的树
    public boolean isSameTree(Node p, Node q){
        //整颗树相同，每个子树也要相同
        if((p == null && q != null) || (p != null && q == null)){
            return false;
        }

        if(p == null && q == null){
            return true;
        }

        if(p.val != q.val) {
            return false;
        }

        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }