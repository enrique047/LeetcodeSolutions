//Partition Labels
class Solution {
    int[] freq;

    public List<Integer> partitionLabels(String s) {
        int n = s.length();

        List<Integer> res = new ArrayList<>();

        freq = new int[26];

        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }

        int i = 0 ;

        for(int j = 0 ; j < n ; j++){
            char ch = s.charAt(j);
            freq[ch - 'a']--;

            if(freq[ch - 'a'] == 0 && isValid(i , j , s)){
                res.add(j - i + 1);
                i = j + 1;
            }
        }

        return res;
    }

    public boolean isValid(int i , int j , String s){
        for(int t = i ; t <= j; t++){
            if(freq[s.charAt(t) - 'a'] != 0){
                return false;
            }
        }

        return true;
    }
}