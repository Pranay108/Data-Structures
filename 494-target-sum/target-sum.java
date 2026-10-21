
class Solution {

    int solve(int[] nums, int target, int idx) {

        if (idx == 0) {
            if (target == 0 && nums[0] == 0) {
                return 2;
            }

            if (target == nums[0] || target == -nums[0]) {
                return 1;
            }

            return 0;
        }

        int notPick = solve(nums, target + nums[idx], idx - 1);

        int Pick = solve(nums, target - nums[idx], idx - 1);

        return Pick + notPick;
    }

    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, target, nums.length - 1);
    }
}

