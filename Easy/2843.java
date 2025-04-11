//Count Symmetric Integers
class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int cnt = 0 ;

        for(int i = low ; i <= high ; i++){
            String str = Integer.toString(i);

            if(str.length() % 2 == 0 && check(str)){
                cnt++;
            }
        }

        return cnt;
    }

    public boolean check(String str){
        int n = str.length();
        int half = 0 , second = 0;

        for(int i = 0 ; i < n / 2; i++){
            half += Integer.parseInt(str.charAt(i) + "");
        }

        for(int i = n / 2  ; i < n ; i++){
            second += Integer.parseInt(str.charAt(i) + "");
        }

        return half == second;
    }
}

