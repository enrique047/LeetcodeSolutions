//Remove All Occurrences of a Substring

class Solution {
    public String removeOccurrences(String s, String part) {
        Stack<Character> st = new Stack<>();

        int n = s.length();
        int m = part.length();

        for(int i =  0; i < n ; i++){
            st.push(s.charAt(i));

            if(st.size() >= m && check(st , part ,  m)){
                for(int j = 0 ; j < m ; j++){
                    st.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }

    public boolean check(Stack<Character> st , String part , int n){
        StringBuilder sb = new StringBuilder();
        Stack<Character> temp = new Stack<>();

        for(Character ch : st){
            temp.push(ch);
        }

        for(int i = 0 ; i < n ; i++){
            sb.append(temp.pop());
        }


        return part.equals(sb.reverse().toString());
    }
}