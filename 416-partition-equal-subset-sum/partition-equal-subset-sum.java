class Solution {
   boolean solve(int [] nums , int target, int idx, int[][]dp){
        if(target == 0) return true;
        if(idx == 0 ) return nums[idx] == target;
        if (dp[idx][target] != -1) {
            return dp[idx][target] == 1;
        }
        boolean notPick = solve(nums, target, idx-1,dp);
        boolean pick = false;
        if(nums[idx]<=target){
            pick = solve(nums,target-nums[idx],idx-1,dp);
        }
        boolean result = pick || notPick;

            if (result) {
                dp[idx][target] = 1;
            } else {
                dp[idx][target] = 0;
            }

return result;
    }
    
    public boolean canPartition(int[] nums) {
        int target = 0; 
        int n = nums.length;
        for(int i: nums){
            target += i;
        }
        if(target%2 != 0) return false;
        target = target /2;
        int[][] dp = new int[n][target + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return  solve(nums,target, nums.length-1,dp);
       

    }
}