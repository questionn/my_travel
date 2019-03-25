class Solution {
    public int romanToInt(String s) {
        int result = 0;
        int n =s.length();
        for(int i = 0; i<n; i++){
        char flag = s.charAt(i);
            switch(flag){//处理正常的情况
                case 'I':
                    result = result + 1;
                    break;
                case 'V':
                    result = result + 5; 
                    break;
                case 'X':
                    result = result + 10;
                    break;
                case 'L':
                    result = result + 50;
                    break;
                case 'C':
                    result = result + 100;
                    break;
                case 'D':
                    result = result + 500;
                    break;
                case 'M':
                    result = result + 1000;
                    break;
                default:
                    ;
            }//处理六种异常的情况
            if(i>0){
            if((flag=='V'||flag=='X')&&(s.charAt(i-1)=='I')){
                result = result -2;}
            if((flag=='L'||flag=='C')&&(s.charAt(i-1) =='X')){
                result = result -20;}
            if((flag=='D'||flag=='M')&&(s.charAt(i-1) =='C')){
                result = result -200;}
            }
        }
        return result;
    }
}