//Longest Substring Of All Vowels in Order
class Solution {
    public int longestBeautifulSubstring(String word) {
        int i = 0 , j = 0 , n = word.length() , result = 0 , cnt = 0;
        char prev = word.charAt(0);
        int unique = 1;

        while(j < n){
            char ch = word.charAt(j);

            if(prev == ch){
                if(unique == 5){
                    result = Math.max(result, j - i + 1);
                }
            }else if(possible(prev , ch)){
                unique++;

                if(unique == 5){
                    result = Math.max(result , j - i  + 1);
                }
                
                prev = ch;
            }else{
                i = j;
                unique = 1;
                prev = word.charAt(i);
            }
            j++;
        }

        return result;
    }

    public boolean possible(char prev , char ch){
        String vowels = "aeiou";

        int prevIdx = vowels.indexOf(prev);
        int currIdx = vowels.indexOf(ch);

        return prevIdx + 1 == currIdx;
    }
}