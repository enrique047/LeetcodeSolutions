//Check if One String Swap Can Make Strings Equal
class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int[] ch1 = new int[26];
        int[] ch2 = new int[26];
        int n = s1.length();
        int cnt = 0;

        for(int i = 0 ; i < n ; i++){
            char t1 = s1.charAt(i);
            char t2 = s2.charAt(i);

            if(t1 != t2){
                cnt++;
            }
            if(cnt > 2){
                return false;
            }

            ch1[t1 - 'a']++;
            ch2[t2 - 'a']++;
        }

        for(int i = 0 ; i < 26 ; i++){
            if(ch1[i] != ch2[i]){
                return false;
            }
        }

        return true;
    }
}