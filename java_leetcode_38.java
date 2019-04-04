class Solution {
    public String countAndSay(int n) {
        if(n == 1)
            return "1";
        String str = countAndSay(n-1) + "*";
        char[] array = str.toCharArray();
        int count =1;
        StringBuffer  sb = new StringBuffer();
        for(int i=0; i<array.length-1; i++){
            if(array[i] == array[i+1]){
                count++;
        }else{
            sb.append("" + count + array[i]);
            count = 1;
        }
     }
        return sb.toString();        
      }
}
