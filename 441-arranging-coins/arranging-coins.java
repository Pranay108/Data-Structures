class Solution {
    public int arrangeCoins(int n) {
        long a = n ;
        long count =0;
        if(n ==1) return 1;
        for(int i = 1 ; i <= n ; i++ ){
         a = a -i;
          if ( a >= 0){
            
            count++;
            
          }
          else  return (int) count;
        }
        return (int)count;

        
    }
}