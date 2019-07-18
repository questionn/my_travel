public static int uglyString(String f) {
        /**
         * 使得出现连续的字符串最小
         * 字符串包括  A,B,?
         * 用？替换使得最小
         *
         * 分四种情况
         */
        //转换为Strignbuffer
        StringBuffer stringBuffer = new StringBuffer(f);
        //定义丑陋数和
        int sum = 0;
        //前面有？
        while(stringBuffer.length()>0 && stringBuffer.charAt(0) =='?'){
            stringBuffer.deleteCharAt(0);
        }
        //后面
        while(stringBuffer.length()>0 && stringBuffer.charAt(stringBuffer.length() -1) == '?'){
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
        }
        //判断中间的
        for (int i = 0; i < stringBuffer.length() ; i++) {
            if(stringBuffer.charAt(i) == '?'){
                //改变 不同
                if (stringBuffer.charAt(i-1) == 'A'){
                    stringBuffer.setCharAt(i,'B');
                }
                if(stringBuffer.charAt(i-1) == 'B'){
                    stringBuffer.setCharAt(i,'A');
                }
            }
            //第一个直接
            if(i == 0){continue;}
            //计算
            if(stringBuffer.charAt(i) == stringBuffer.charAt(i-1)){
                sum++;
            }
        }
        return sum;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String s = scanner.nextLine();
            int i = uglyString(s);
            System.out.println(i);

        }
    }