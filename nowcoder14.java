//组个最小数
    public static String conMinNum(int[] A){
        StringBuilder sb = new StringBuilder();
        int i = 1;
        while(A[i] == 0){
            i++;
        }
        A[i] = A[i] - 1;
        sb.append(i);
        for (int j = 0; j < A.length; j++) {
            for (int k = 1; k <= A[j]; k++) {
                sb.append(j);
            }
        }
        return sb.toString();
    }
        //尼科切斯定理  每个数的三次方都可以由连续的奇数组成
    public String GetSequeOddNum(int m){
        StringBuilder sb = new StringBuilder();
        int tmp = m*m - m +1;
        // (m*(m-1))+1
        for (int i = 1; i < m ; i++) {
            sb.append(tmp);
            sb.append("+");
            tmp+=2;
        }
        sb.append(tmp);
        return sb.toString();
    }
    public static void main(String[] args) {
        Test12$00 test12$00 = new Test12$00();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int m = scanner.nextInt();
            System.out.println(test12$00.GetSequeOddNum(m));
        }

    }
        /*14天测试用例1
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] a = s.split(" ");
        int[] tmp = new int[a.length];
        for (int i = 0; i < a.length ; i++) {
            tmp[i] = Integer.parseInt(a[i]);
        }
        System.out.println(conMinNum(tmp));
        测试用例2
        System.out.println((int)pow(1,3));//1
        System.out.println((int)pow(2,3));//3 5
        System.out.println((int)pow(3,3));//7 9 11
        System.out.println((int)pow(4,3));//13 15 17 19
        System.out.println((int)pow(5,3));//21
    }*/