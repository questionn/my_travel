public class Test6 {
    public static void quickSort(int[] tmp, int low, int high) {
        if (low >= high) {
            return;
        }
        int i = low;
        int j = high;
        int flag = tmp[low];
        while (i < j) {
            while (tmp[j] >= flag && i < j) {
                j--;
            }
            while (tmp[i] <= flag && i < j) {
                i++;
            }
            if (i < j) {
                int ex = tmp[i];
                tmp[i] = tmp[j];
                tmp[j] = ex;
            }
        }
        tmp[low] = tmp[i];
        tmp[i] = flag;
        quickSort(tmp, low, j-1);
        quickSort(tmp, j + 1, high);
    }

    public static int mostTimes(int[] A){
        quickSort(A,0,A.length-1);
        int count = 0;
        int tmp = 0;
        int left = 0;
        int right = A.length-1;
        while(left<right){
            while(A[left] == A[left+1] && left<right){
                left++;
                count++;
            }
            if(count >= A.length/2-1){
                tmp = A[left];
            }
            left++;
            count = 0;
        }
        return tmp;
    }
    //A-B B-C A+B B+C
    public static void findBoySweet(int num1, int num2, int num3, int num4) {
        int A = (num1 + num3) / 2;
        int B = (num2 + num4) / 2;
        int C = (num4 - num2) / 2;

        if ((A - B == num1) && (B - C == num2) && (A + B == num3) && (B + C == num4)) {
            System.out.println(A + " " + B + " " + C);
        } else {
            System.out.println("No");
        }
    }

    //3 9 3 2 5 6 7 3 2 3 3 3
    //2 2 3 3 3 3 3 3 5 6 7 9
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String[] string = scanner.nextLine().split(" ");
            int[] num = new int[string.length];
            for (int i = 0; i < num.length; i++) {
                num[i] = Integer.parseInt(string[i]);
            }
            System.out.println(mostTimes(num));
        }

    }
}



/*Scanner scanner = new Scanner(System.in);
        int boyA = scanner.nextInt();
        int boyB = scanner.nextInt();
        int boyC = scanner.nextInt();
        int boyD = scanner.nextInt();
        findBoySweet(boyA, boyB, boyC, boyD);*/
