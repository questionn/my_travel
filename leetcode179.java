public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int curSum = 0;
        for(int i = 0; i < nums.length; i++){
            if(curSum > 0){
                //证明此前的cur还有用
                curSum += nums[i];
            }else{
                //已经是处于负数  或者零
                //使得没有cur为正  任何数有机会成为最大
                curSum = nums[i];
            }
            //每次判断  有可能当前cur 等于负数
            //不可能漏掉负数为最大  因为maxSum为正数或负数
           maxSum = Math.max(maxSum,curSum);
            
        }
        return maxSum;
    }