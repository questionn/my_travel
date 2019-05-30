public class Main {
    //给定N，判断离最近的斐波那契数有几步远
    public static int FibonacciN(int N){
        if(N == 0){
            return 0;
        }
        if(N == 1){
            return 0;
        }
        int bre = 0;
        int pre = 1;
        int ret = 0;
        while(N > ret){
            ret = bre + pre;
            bre = pre;
            pre = ret;
        }
        if(N == ret){
            return 0;
        }else {
            if ((ret - N) > (N - bre)) {
                return N - bre;
            } else {
                return ret - N;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.println(FibonacciN(a));
    }
}