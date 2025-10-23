//Check If Digits Are Equal in String After Operations I
class Solution {
    public boolean hasSameDigits(String s) {

        while(s.length() != 2){
            char[] t = s.toCharArray();
            StringBuilder sb = new StringBuilder();

            for(int i = 0 ; i < t.length - 1 ; i++){
                char ch = (char)((((t[i] - '0') + (t[i+1] - '0')) % 10 ) + '0');
                sb.append(ch);
            }

            s = sb.toString();
        }

        return s.charAt(0) == s.charAt(1);
    }
}