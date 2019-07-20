public static String veryVeryBig(int n, int[] src){
        //转换为String数组
        //使用比较器进行排序   (按照两个字符串相加  得到那个最大排序   a~b > b~a    ~拼接)
        //拼接
        
        //判断是否为空
        if(src == null){
            return "0";
        }
        //由于String比较好操控
        String[] strs = new String[src.length];
        for (int i = 0; i < src.length; i++) {
            strs[i] = String.valueOf(src[i]);
        }
        //对数组进行指定排序
        Arrays.sort(strs,new ComparatorMostNum() );
        //特殊情况  连续0
        if(strs[0].equals("0")){
            return "0";
        }
        //拼接
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            if(strs[i] != "0"){
                stringBuilder.append(strs[i]);
            }
        }
        //返回
        return stringBuilder.toString();
    }