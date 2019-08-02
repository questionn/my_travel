import java.util.*;

public class Solution {
         //数组中出现超过一般的数字
    public int MoreThanHalfNum_Solution(int [] array){
        if(array.length == 0 || array == null){
            return 0;
        }
        //使用hashTable
        HashMap<Integer,Integer> countMap = new HashMap<>();
        countMap.put(array[0],1);
        //寻找相同的元素
        for (int i = 1; i < array.length ; i++) {
            if(countMap.containsKey(array[i])){
                countMap.put(array[i], countMap.get(array[i])+1);
            }else{
                countMap.put(array[i], 1);
            }
        }
        //查找
        int tmp = 0;
        Iterator<Map.Entry<Integer, Integer>> iterator = countMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> ret = iterator.next();
            if(ret.getValue() > array.length/2){
                tmp = ret.getKey();
            }
        }
        return tmp;
    }
}