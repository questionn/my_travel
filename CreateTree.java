public Node createTestTree(String tree){
        //前序遍历生成
        Node root = null;
        //如果不是#字符，那么创建节点
        if(tree.charAt(i) != '#'){
            root = new Node(tree.charAt(i));
            i++;
            root.left = createTestTree(tree);
            root.right = createTestTree(tree);
        }else {
            i++;
        }
        return root;
    }