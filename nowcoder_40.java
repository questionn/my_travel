	//删除公共字符
	public static String deleteCommonChar(String src, String flag){
        //flag为空
        if(flag == null){
            return src;
        }
        //使用Stringbuffer
        StringBuilder stringBuilder = new StringBuilder(src);
        StringBuilder stringBuilder1 = new StringBuilder();
        int srcLength = stringBuilder.length();
        int flagLength = flag.length();
        //o(n2)便利
        for (int i = 0; i <srcLength; i++) {
            for (int j = 0; j < flagLength ; j++) {
                if(stringBuilder.charAt(i) == flag.charAt(j)){
                    break;
                }else if(j == flagLength-1){
                    stringBuilder1.append(stringBuilder.charAt(i));
                }
            }
        }
        return stringBuilder1.toString();
    }
    //句子逆序
    public static String reverseWords(String src){
        //如果为空
        if(src == null){
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        //使用空格划分
        String[] tmp = src.split(" ");
        //逆序加入
        for (int i = tmp.length-1; i >= 0 ; i--) {
            if(i == 0) {
                stringBuilder.append(tmp[0]);
                break;
            }
            stringBuilder.append(tmp[i]).append(" ");
        }
        return stringBuilder.toString();
    }