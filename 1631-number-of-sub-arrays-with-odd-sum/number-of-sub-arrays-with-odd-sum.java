class Solution {
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for(int i = 1; i< n;i++){
            prefix[i] = prefix[i-1]+arr[i];
        }
        int count = 0;
        int even = 1;
        int odd = 0;
        for(int i = 0 ;i < n ;i++){
            if(prefix[i] % 2 ==0){
                count = (count+odd)%1000000007;
                even++;
            }
            else{
                count=(even+count)%1000000007;
                odd++;
            }
        }
        return count;
    }
}