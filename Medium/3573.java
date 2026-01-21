//Best Time to Buy and Sell Stock V
class Solution {
    long[][][] t;

    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;

        t = new long[n][k+1][3];

        return solve(0 , k , 0 , prices);
    }

    public long solve(int idx , int k , int cse , int[] p){
        
        if(idx >= p.length){
            if(cse == 0) return 0;

            return -(long)1e18;
        }

        if(t[idx][k][cse] != 0){
            return t[idx][k][cse];
        }

        long notTake = solve(idx + 1 , k , cse , p);

        long take = -(long)1e18;

        if(k > 0){
            if(cse == 1){
                take = ( p[idx] + solve(idx + 1 , k - 1 , 0 , p) );
            }else if(cse == 2){
                take = ( -p[idx] + solve(idx + 1 , k - 1 , 0 , p) );
            }else{
                take = Math.max( -p[idx] + solve(idx + 1 , k , 1 , p) , p[idx] + solve(idx + 1 , k  , 2 , p) );
            }
        }

        return t[idx][k][cse] = Math.max(take , notTake);
    }
}