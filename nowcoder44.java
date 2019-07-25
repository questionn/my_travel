//单词倒排
 public static String wordRevers(String s){
        //将单词的之外的所有转换成空格
        int length = s.length();
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer1 = new StringBuffer();
        for (int i = 0; i < length; i++) {
            char tmp = s.charAt(i);
            if(tmp >= 'a' && tmp <= 'z' || tmp >= 'A' && tmp <= 'Z'){
                stringBuffer.append(tmp);
            }else{
                stringBuffer.append(" ");
            }
        }
        //使用正则表达式
        String ret = stringBuffer.toString();
        String[] ret1 =  ret.split("\\s+");
        for (int i = ret1.length-1; i >= 0 ; i--) {
            if(i == 0){
                stringBuffer1.append(ret1[i]);
            }else {
                stringBuffer1.append(ret1[i]);
                stringBuffer1.append(" ");
            }
        }
        return stringBuffer1.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            while(scanner.hasNextLine()){
                String s = scanner.nextLine();
                String ret = wordRevers(s);
                System.out.println(ret);
        }
	
//驼峰命名法
// write your code here

import java.util.*;

public class Main{
    
    public static String humpName(String s){
        String[] tmp = s.split("_");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(tmp[0]);
        for (int i = 1; i < tmp.length ; i++) {
            String ha = Character.toUpperCase(tmp[i].charAt(0))+tmp[i].substring(1);
            stringBuffer.append(ha);
        }
        return stringBuffer.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String str = scanner.nextLine();
            String ret = humpName(str);
            System.out.println(ret);
        }
    }
}