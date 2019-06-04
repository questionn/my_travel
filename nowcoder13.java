//两个超长整数相加，返回字符串
//使用Math里面的BigInteger
public static String myLongNumber(String f, String t){
        BigInteger bigInteger1 = new BigInteger(f);
        BigInteger bigInteger2 = new BigInteger(t);
        bigInteger1 = bigInteger1.add(bigInteger2);
        return bigInteger1.toString();

    }
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       while(scanner.hasNext()){
           String s1 = scanner.nextLine();
           String s2 = scanner.nextLine();
           System.out.println(myLongNumber(s1,s2));
       }
    }
	
//跟奥巴马一起学编程，输出一个正方形，宽为长的大约50%
public static void obmLearn(int N, String c) {
        for (int i = 1; i <= N-1; i++) {//输出第一行
            System.out.print(c);
        }
        System.out.println();
        //中间行，两边为符号，中间为空字符
        for (int i = 1; i <= Math.ceil((double) N / 2) - 2; i++) {//输出中间行
            System.out.print(c);//中间行第一个字符
            for (int j = 2; j <= N - 1; j++) {
                System.out.print(" ");//中间行其它字符为空字符串
            }
            System.out.println(c);//中间行最后一个字符
        }
        for (int i = 1; i <= N; i++) {//输出最后一行
            System.out.print(c);
        }
    }