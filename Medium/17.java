//Letter Combinations of a Phone Number
class Solution {
    Map<Character, String> mp;
    List<String> res = new ArrayList<>();
    int n;

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return res;  
        }

        mp = new HashMap<>();
        n = digits.length();
        
        mp.put('2', "abc");
        mp.put('3', "def");
        mp.put('4', "ghi");
        mp.put('5', "jkl");
        mp.put('6', "mno");
        mp.put('7', "pqrs");
        mp.put('8', "tuv");
        mp.put('9', "wxyz");

        solve(0 , digits, new StringBuilder());

        return res;
    }

    public void solve(int idx , String s  , StringBuilder temp){
        if(idx >= n){
            res.add(temp.toString());
            return;
        }
        
        String t = mp.get(s.charAt(idx));

        for(int i = 0 ; i < t.length() ; i++){
            temp.append(t.charAt(i));
            solve(idx + 1 , s , temp );
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}