//45  乒乓球框
    public static String pingPang(String str1, String str2){
        /**
         * 问题：
         * str2中的所有元素，都必须被str1包括
         * 并且str1的包括元素个数都大于str2
         *
         * 思路:
         * 1、判断str1中是否存在str2的字符，不存在直接return
         * 2、将两个字符串分别，变为Map集合
         * 3、使用迭代器，（此时str2的元素全部都包含在str1中）
         * 4、检验相等时，个数是否相同
         *
         * 乱
         *
         * 收货：迭代器可以进行嵌套
         *
         */
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        //如果字符串str2中有str1没有的直接退出
        for (int i = 0; i < char2.length; i++) {
            String tmp = String.valueOf(char2[i]);
            if(!(str1.contains(tmp))){
                return "No";
            }
        }
        Map<Character,Integer> mapStr1 = new HashMap<>();
        Map<Character,Integer> mapStr2 = new HashMap<>();
        for (int i = 0; i < char1.length ; i++) {
            if(mapStr1.containsKey(char1[i])){
                mapStr1.put(char1[i],mapStr1.get(char1[i])+1);  ////
            }else{
                mapStr1.put(char1[i],1);
            }
        }
        for (int i = 0; i < char2.length ; i++) {
            if(mapStr2.containsKey(char2[i])){
                mapStr2.put(char2[i],mapStr2.get(char2[i])+1);  ////
            }else{
                mapStr2.put(char2[i],1);
            }
        }
        //使用迭代器
        Set<Entry<Character, Integer>> entries = mapStr1.entrySet();
        Iterator<Map.Entry<Character,Integer>> iterator = entries.iterator();
        //
        Set<Entry<Character, Integer>> entries1 = mapStr2.entrySet();

        boolean flag = true;
        while(iterator.hasNext()){
            Map.Entry<Character,Integer> entry = iterator.next();
           /* System.out.println(entry.getKey() + " " + entry.getValue());*/
            Iterator<Map.Entry<Character,Integer>> iterator1 = entries1.iterator();
            while (iterator1.hasNext()){
                Map.Entry<Character,Integer> entry1 = iterator1.next();
//                System.out.println(" 1 " + entry1.getKey() + " " + entry1.getValue());
                if(entry.getKey().equals(entry1.getKey()) && entry.getValue() < entry1.getValue() ) {
                    flag = false;
                }
               /* System.out.println(flag);*/
            }

        }
        if(flag)
            return "Yes";
        else
            return "No";
    }
    public static void main(String[] args) {
          Scanner s = new Scanner(System.in);
          while(s.hasNextLine()){
              String s1 = s.nextLine();
              String[] strings = s1.split(" ");
              String ret = pingPang(strings[0],strings[1]);
              System.out.println(ret);
          }
    }