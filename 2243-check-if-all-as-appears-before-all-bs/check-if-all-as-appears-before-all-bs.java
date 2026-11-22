class Solution {
    public boolean checkString(String s) {
        boolean a = true;
        boolean b = true;
        for(int i = 0 ; i< s.length();i++){
            if(s.charAt(i)=='a'){
                if(b == false){
                    return false;
               
                }
                a = false;
            }
            else{
                b = false;
            }

        }
        return true;
    }
}