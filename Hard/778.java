//Swim in Rising Water
class Solution {
    int n ;
    int[][] dir = new int[][]{{1,0} , {-1,0} , {0,1} , {0 ,-1}};

    public int swimInWater(int[][] grid) {
        n = grid.length;

        int l = 0 , r = (n*n) - 1;

        int res = 0;

        while(l < r){
            int mid = l + (r - l) / 2;

            if(grid[0][0] <= mid && isPossible(grid , mid , 0 , 0 , new boolean[n][n])){
                r = mid;
            }else{
                l = mid + 1;
            }
        }

        return l;
    }

    public boolean isPossible(int[][] grid , int time  , int i , int j , boolean[][] visited){

        if(i >= n || j >= n || i < 0 || j < 0 || grid[i][j] > time || visited[i][j]){
            return false;
        }
        
        if(i == n - 1 && j == n - 1) return true;

        visited[i][j] = true;

        for(int[] d: dir){
            int ix = i + d[0];
            int jx = j + d[1];

            if(isPossible(grid , time , ix , jx , visited)){
                return true;
            }
        }

        
        return false;
    }
}