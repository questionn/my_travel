   优化，返回中间节点，如果是偶数，返回后一个
   public Node middleNode(){
        Node cur = this.head;
        Node pre = this.head;
        while(cur != null && cur.next != null){                       //判断奇数个和偶数个情况
            cur = cur.next.next;
            pre = pre.next;
        }
        return pre;
    }

	返回中间节点，如果是偶数，返回前一个
    public Node middlePreNode(){
        Node cur = this.head;
        Node pre = this.head;
        if(cur == null)
            return null;
        if(cur.next == null)
            return this.head;
        cur = cur.next.next;
        while(cur != null && cur.next !=null){
            cur = cur.next;
            pre = pre.next;
        }
        return pre;
    }