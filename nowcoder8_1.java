//寻找最小的K个数，升序排列
//输入一个数组，最后一个表示K
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
        quickSort(tmp, low, j - 1);
        quickSort(tmp, j + 1, high);
    }

    public static int[] findMinK(int[] A) {
        int tmp = A[A.length - 1];
        quickSort(A, 0, A.length - 2);
        int[] B = new int[tmp];
        for (int i = 0; i < tmp; i++) {
            B[i] = A[i];
        }
        return B;
    }