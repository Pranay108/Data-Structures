class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
         long count =0 ;
         long length = 0;
         int n  = nums.length;
         
            for(int j = 0; j<n;j++){
                if(nums[j]>=minK && nums[j]<=maxK){
                length++;
                count+= length;
                } 
                else {
                    length=0;
            }
            }
         return count;
    }
}