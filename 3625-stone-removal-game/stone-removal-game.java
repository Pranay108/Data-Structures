class Solution {
    public boolean canAliceWin(int n) {
        boolean alice = true;
        for(int i = 10; i>0;i--){
            if(n<0) break;
            n = n-i;
            alice = !alice;
        }
        return alice;
    }
}