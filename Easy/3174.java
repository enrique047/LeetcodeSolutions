//Clear Digits
class Solution {
    public String clearDigits(String s) {

        int n = s.length();

        Stack<Character> st = new Stack<>();

        for(int i  = 0 ; i < n ; i++){
            if(Character.isDigit(s.charAt(i)) && !st.isEmpty() && !Character.isDigit(st.peek())){
                st.pop();
            }else{
                st.push(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}