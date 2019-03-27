import java.lang.StringBuffer;
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null)//判断是否为空
            return null;
        if(strs.length == 1)//判断是否是一个字符串
            return strs[0];
        StringBuffer sb = new StringBuffer();
        if(strs.length>1){
            int length = strs[0].length();//去第一个数组元素为基准
            for(int i=0; i<length; i++){
                 char target = strs[0].charAt(i);//先去比较第一个字符串第一个元素
                     for(int j=1; j<strs.length; j++){
                         if((strs[j].length()<=i)||(strs[j].charAt(i) != target)){
                             return sb.toString();//不相等，或者长度小于，就可以返回了
                         }
                         if((j == strs.length-1 )&&strs[j].charAt(i)==target)
                             sb.append(target);//相等保存下来    
            }
            
        }
        
    }
        return sb.toString();
 }
}