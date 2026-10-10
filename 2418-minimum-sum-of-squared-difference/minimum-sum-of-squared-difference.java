class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int [] freq = new int[1000001];
        long k = (long)k1+k2;
        long ans = 0;
        int max = -1;
        int total = 0;
        for(int i = 0 ; i< nums1.length;i++){
            int diff = Math.abs(nums2[i]-nums1[i]);
            freq[diff]++;
            max = Math.max(max,diff);
            total+= diff;
        }
        
        for(int i = max;i>0;i--){
            if(freq[i]==0) continue;
            if(k>=freq[i]){
                k -= freq[i];
                freq[i - 1] += freq[i];
                freq[i] = 0;

            }
            else{
                freq[i]-= (int) k;
                freq[i-1] += (int) k;
                k= 0;
            }

        }

        for (int d = 1; d <= max; d++) {
            ans += (long) d * d * freq[d];
        }

        return ans;
    }
}