class Solution {
    public int searchInsert(int[] nums, int target){
        int left = 0;
        int right = nums.length;
        return bSort(nums, left, right, target);
        
    }
    public int bSort(int[] nums, int left, int right, int target){
        if(target < nums[0])
            return 0;
        if(target > nums[nums.length-1])
            return nums.length;
        while(left <= right){
            int mid = (left+right)/2;
            if((nums[mid] == target) || (nums[mid]>target)&&(nums[mid-1]<target))
                return mid;
            else if((nums[mid] < target)&&(nums[mid+1] > target))
                return mid+1;
            else if(nums[mid] > target){
                right = mid;
            }else{
                    left = mid;
            }
        }
        return 0;
    }
}