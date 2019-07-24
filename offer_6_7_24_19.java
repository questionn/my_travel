import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if(array == null && array.length == 0){
            return 0;
        }
        int minValue = 0;
        int maxValue = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] >= maxValue){
                maxValue = array[i];
            }else{
                minValue = array[i];
                break;
            }
        }
        return minValue;
    }
}