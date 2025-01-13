//Minimum Length of String After Operations
class Solution {
    public int minimumLength(String s) {
        int[] freq = new int[26];

        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;

            if(freq[ch - 'a'] >= 3){
                freq[ch - 'a'] -= 2;
            }
        }

        int ans = 0;

        for(int i = 0 ; i < 26 ; i++){
            ans += freq[i];
        }

        return ans;
    }
}