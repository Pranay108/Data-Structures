class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            for(int j =i;j<n;j++){
               int sum = 0;
               for(int k = i; k<=j;k++){
                sum += nums.get(k);
               }
               int len = j-i+1;
               if(len >= l && len <= r && sum>0){
                ans = Math.min(ans,sum);
               }
            }
        }
        if(ans < 0) return -1;
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
}