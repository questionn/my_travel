 public class Main{
 //神奇的口袋
    //口袋容量40,
    //john想要取1到n个物品，每个物品的体积分别是a1，a2……an，有几种组合可以取出等于40的物品组合
    static int N;
    static int[] weight;
    static int count = 0;
    public static void magicPackage(int s, int n) {//40的口袋(变化0)    总共有几个几个
        //采用递归
        if (s == 0) {
            ++count;
            return;
        }
        if (s < 0 || (n < 1 && s > 0)) {//容量小于0排除      没有n
            return;
        }
        //先进行递归，寻找第一次的成立
        magicPackage(s - weight[n], n - 1);
        //发现不成立，或者已经成立，就递归后面的
        magicPackage(s, n - 1);
        //容量不变，等于删除了本轮的n-1节点，之后调用第一次递归

        //(第一行的递归调用完，就是用第二个递归)
    }
 public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            N = scanner.nextInt();
            weight = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                weight[i] = scanner.nextInt();
            }
            magicPackage(40, N);
            System.out.print(count);
        }
    }
}