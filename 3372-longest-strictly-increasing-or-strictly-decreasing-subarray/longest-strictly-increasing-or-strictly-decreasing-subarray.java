class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc = 1;
        int n = nums.length;
        int count = 1;
        for(int i = 1; i<n;i++){
            if(nums[i-1]<nums[i]){
                inc++;
            }
            else{
                
                inc = 1;
                
            }
            count = Math.max(inc,count);
        }
          int dec=1;
         int count2 = 1;
         for(int i = 1; i<n;i++){
            if(nums[i-1]>nums[i]){
                dec++;
            }
            else{
                
                dec=1;
                
            }
            count2 = Math.max(dec,count2);
        }
        return Math.max(count,count2);
    }
}