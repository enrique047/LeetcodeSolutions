//Construct K Palindrome Strings
class Solution {
    public boolean canConstruct(String s, int k) {
        int n = s.length();

        if(k > n){
            return false;
        }

        if(k == n){
            return true;
        }

        int[] freq = new int[26];

        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }

        int cnt = 0 , ev = 0;

        for(int i = 0 ; i < 26 ; i++){
            if(freq[i] % 2 == 1){
                cnt++;
            }
        }

        return cnt <= k;
    }
}