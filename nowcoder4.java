public class Test3 {
    //字符串中找出连续最长的数字串
    //解法二
    public static String FindLongNumber1(String s){
        if(s == null){
            throw new UnsupportedOperationException();
        }
        int len = s.length();
        int count=0;
        int max=0;
        int tmp=0;//计数器，最长数字，下标
        for (int i = 0; i < len; i++) {
            if('0' <= s.charAt(i) && s.charAt(i) <= '9'){
                count++;
                if(count > max) {
                    max = count;
                    tmp = i;
                }
            }else{
                  count = 0;
                }
            }
        return s.substring(tmp-max+1,tmp+1);
        }
    //解法一
    public static String FindLongNumber(String s){
        char[] array = s.toCharArray();
        int len = array.length;
        if(len == 1 && 48<= array[0] && array[0]<=57){
            return s;
        }
        int count1 = 0;
        int tmp = 0;
        int i =0;
        while(i<len) {
            int count = 0;
            int j = 0;
            if (48 <= array[i] && array[i] <= 57) {
                j = i;
                while (48 <= array[j] && array[j] <= 57 && j < len) {
                    count++;
                    if (j == len - 1) {
                        break;
                    }
                    j++;
                }
                if (count > count1) {
                    count1 = count;
                    tmp = i;
                }
            }
            i++;
        }
        return s.substring(tmp,tmp+count1);
    }
//括号匹配
    public static boolean chkParenthesis2(String A, int n ){
        if(A == null && n != A.length()){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            if(A.charAt(i) == '('){
                stack.push(A.charAt(i));
            }else if(A.charAt(i) == ')'){
                if(stack.empty()){
                    return false;
                }else {
                    stack.pop();
                }
            }else {
                return false;
            }
        }
        if(!stack.empty()){
            return false;
        }else{
            return true;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String result = FindLongNumber1(s);
        System.out.println(result);

    }
}
