import java.util.*;

public class Main{
     public static void shouXingNum(int N){
        //变成平方
        int pow2 = N*N;
        while (N != 0){
            int var1 = N%10;
            int var2 = pow2%10;
            if(var1 != var2){
                break;
            }
            N = N/10;
            pow2 = pow2/10;
        }
        if(N != 0){
            System.out.println("No!");
        }else{
            System.out.println("Yes!");
        }
    }
    
     public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int num = scanner.nextInt();
            shouXingNum(num);
        }
    }
}