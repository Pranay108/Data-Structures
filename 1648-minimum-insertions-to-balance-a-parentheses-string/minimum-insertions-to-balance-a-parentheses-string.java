class Solution {
    public int minInsertions(String s) {
        Stack<Character> st = new Stack<>();
        int count = 0;
        for(int i = 0; i< s.length();i++){
            char a = s.charAt(i);
            if(a=='('){
                st.push(a);
            }
            else{
                if(s.length()> i+1 && s.charAt(i+1)==')'){
                    i++;
                }
                else{
                    count++;
                }
                if(!st.isEmpty()) st.pop();
            else{
                count++;
            }
            }
            
        }
        return count+(st.size()*2);
    }
}