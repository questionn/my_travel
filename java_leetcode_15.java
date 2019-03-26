class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result =new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]>0){
                break;
            }//判断是否全为正
            if(i>0&&(nums[i]==nums[i-1]))
                continue;
            int j=nums.length-1;//定义j为最后一个元素
            int targer = 0 - nums[i];//目标的结果
            int k =i+1;
            while(k<j){//判断k是否找完
                if(nums[k]+nums[j]==targer){
                    List<Integer> item = Arrays.asList(nums[i],nums[k],nums[j]);
                    result.add(item);//相等 加入到数组
                    while(k<j&&(nums[k]==nums[k+1]))//后面同样数字，++
                        k++;
                    while(k<j&&(nums[j]==nums[j-1]))//前面有同样的数字,--
                        j--;
                    k++;//如果相等，就直接进行下一轮的比较
                    j--;
                }
                else if(nums[k]+nums[j]<targer){//小于就移动k
                    k++;
                }
                else//大于移动j
                    j--;
                }
            }
        return result;
            }
          }
 