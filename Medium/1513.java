//Number of Substrings With Only 1s
class Solution {
    int MOD = 1000000007;

    public int numSub(String s) {
        int res = 0;
        int i = 0 , j = 0 , n = s.length();

        for(; j < n ; j++){

            while(j + 1 < n && s.charAt(j + 1) == '1'){
                j++;
            }

            while(i < n && s.charAt(i) == '0'){
                i++;
            }

            if(i < n && j < n && s.charAt(i) == '1' && s.charAt(j) == '1'){
                int len = ( j - i + 1);
                long L = len;
                long val = (L % MOD) * ((L + 1) % MOD);
                val %= MOD;
                val = val / 2;
                val %= MOD;
                res = (int)((res + val) % MOD);


                i = j + 1;
            }
        }

        return res;
    }
}