//Number of Smooth Descent Periods of a Stock
class Solution {
    public long getDescentPeriods(int[] p) {
        long res = 0;

        int i = 0 , j = 0 ;
        long n = p.length ;

        while(j < n){
            if(j != 0 && p[j-1] - 1 != p[j]){

                long L = (j - i);
                res += (L * (L + 1) / 2);
                i = j ;

            }
            j++;
        }

        long L = n - i;
        res += (long) L * (L + 1) / 2;

        return res  ; 
    }
}
