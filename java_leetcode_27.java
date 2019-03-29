class Solution {
    public int removeElement(int[] nums, int val) {
        //双指针遍历
        //因为要返回不是val的值个数，所以不相等时候i++，相等时候i停下
        int i =0;
        for(int j=0; j<nums.length; j++){
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
       return i;
    }
}