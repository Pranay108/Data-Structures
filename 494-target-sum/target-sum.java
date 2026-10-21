// class Solution {

//     int solve(int[] nums,  int idx, int currSum, int target, int [][]dp) {
//         if(dp[idx][currSum]!=-1) return dp[idx][currSum];
//         if (idx == nums.length) {
//         if (currSum == target) return 1;
//     else return 0;
// }

// int plus = solve(nums, idx + 1, currSum + nums[idx], target, dp );
// int minus = solve(nums, idx + 1, currSum - nums[idx], target, dp );

// return dp[idx][currSum] =  plus + minus;
//     }

//     public int findTargetSumWays(int[] nums, int target) {
//         int sum = 0;
//         for(int i : nums){
//             sum += i;
//         }
//        int[][] dp = new int[nums.length][2 * sum + 1];

//         for (int[] row : dp) {
//             Arrays.fill(row, -1);
//         }
       
//         return solve(nums,0 , 0 ,target, dp);
//     }
// }

class Solution {

    int solve(int[] nums,  int idx, int currSum, int target,HashMap<String,Integer> dp) {
        
        if (idx == nums.length) {
        if (currSum == target) return 1;
    else return 0;
}
String key = idx + " " + currSum;
if(dp.containsKey(key)){
    return dp.get(key);
}

int plus = solve(nums, idx + 1, currSum + nums[idx], target, dp );
int minus = solve(nums, idx + 1, currSum - nums[idx], target, dp );
 dp.put(key, plus+minus);
return   plus + minus;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
       HashMap<String,Integer> dp = new HashMap<>();

       
       
        return solve(nums,0 , 0 ,target, dp);
    }
}