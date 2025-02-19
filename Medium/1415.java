//The k-th Lexicographical String of All Happy Strings of Length n
class Solution {
    List<String> res = new ArrayList<>();
    int N;

    public String getHappyString(int n, int k) {
        N = n;

        solve(new StringBuilder());

        if(res.size() < k){
            return "";
        }

        return res.get(k - 1);
    }

    public void solve(StringBuilder sb){
        if(N == sb.length()){
            res.add(sb.toString());
            return;
        }

        for(char ch : new char[]{'a', 'b', 'c'}){
            if(sb.length() > 0 &&  sb.charAt(sb.length() - 1) == ch ){
                continue;
            }

            sb.append(ch);
            solve(sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}