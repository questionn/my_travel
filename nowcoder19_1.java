//子串判断
 public boolean[] chkSubStr(String[] p, int n, String s){
        //返回一个boolean数组
        boolean[] ret = new boolean[n];
        //遍历字符串
        for (int i = 0; i < n; i++) {
            if(s.contains(p[i])){
                ret[i] = true;
            }else{
                ret[i] = false;
            }
        }
        return ret;
    }
	