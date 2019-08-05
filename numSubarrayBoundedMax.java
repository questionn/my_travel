问题：
给定一个元素都是正整数的数组A ，正整数 L 以及 R (L <= R)。

求连续、非空且其中最大元素满足大于等于L 小于等于R的子数组个数。

思路：
  小于L 的个数  ---   小于等于R的个数   ===  结果
  
  每次连续都会产生 1 2 3 4 5.。。这样的情况


class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        //结论就是 小于等于最大的R   减去   小于一个L
        //遍历数组去分别计算
        int countL = 0;
        int testL = 0;//保存连续产生的 1 ，2 ，3...
        //计算L
        for(int i = 0; i < A.length; i++){
            if(A[i] < L){
                testL++; //如果是连续的话会产生   1 , 2  , 3,  4
                countL = countL + testL;
            }else{
                //证明已经断了（超出最大）
                testL = 0;//前面的失败
            }
            
        }
        
        int countR = 0;
        int testR = 0;//保存连续产生的 1 ，2 ，3...
        //计算L
        for(int i = 0; i < A.length; i++){
            if(A[i] <= R){
                testR++; //如果是连续的话会产生   1 , 2  , 3,  4
                countR = countR + testR;
            }else{
                //证明已经断了（超出最大）
                testR = 0;//前面的失败
            } 
        }
        
        return countR - countL;
    }
}