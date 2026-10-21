class Solution {

    int solve(int[] nums,  int idx, int currSum, int target) {

        if (idx == nums.length) {
    if (currSum == target) return 1;
    else return 0;
}

int plus = solve(nums, idx + 1, currSum + nums[idx], target);
int minus = solve(nums, idx + 1, currSum - nums[idx], target);

return plus + minus;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
       int[][] dp = new int[nums.length][2 * sum + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
       
        return solve(nums,0 , 0 ,target);
    }
}