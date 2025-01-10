//Counting Words With a Given Prefix
class Solution {
    public int prefixCount(String[] words, String pref) {
        int res = 0 , n = words.length;

        for(int i = 0 ; i < n ; i++){
            if(words[i].indexOf(pref) == 0){
                res++;
            }
        }

        return res;
    }
}