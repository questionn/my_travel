    //输入两个字符串，删除A字符中包含的B字符串
    public static String deleteAInB(StringBuffer A, StringBuffer B){
        if(A == null){
            return null;
        }
        StringBuffer tmp = new StringBuffer();
        for (int i = 0; i < A.length(); i++) {
            int j = 0;
            while(j<B.length()){
                if(A.charAt(i) ==B.charAt(j)){
                    break;
                }
                if(A.charAt(i) !=B.charAt(j) && j==B.length()-1){
                    tmp.append(A.charAt(i));
                }
                j++;
            }
        }
        return tmp.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            String A = scanner.nextLine();
            String B = scanner.nextLine();
            String result = deleteAInB(new StringBuffer(A), new StringBuffer(B));
            System.out.println(result);
    }