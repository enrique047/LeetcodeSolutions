//Magic Squares In Grid
class Solution {
    int n , m ;

    public int numMagicSquaresInside(int[][] grid) {
        int res = 0;

        n = grid.length;
        m = grid[0].length;

        for(int i = 0 ; i < n - 2; i++){
            for(int j = 0 ; j < m - 2; j++){
                if(solve(i , j , grid)){
                    res += 1;
                }
            }
        }

        return res;
    }

    public boolean solve(int x , int y , int[][] grid){
        int[] freq = new int[10];

        for(int i = x ; i < x + 3 && i < n ; i++){
            for(int j = y ; j < y + 3 && j < m ; j++){

                if(grid[i][j] > 9 || grid[i][j] <= 0 || freq[grid[i][j]] == 1){
                    return false;
                }

                freq[grid[i][j]] = 1;
            }
        }

        int s = grid[x][y] + grid[x][y+1] + grid[x][y+2];

        for(int i = 0 ; i < 3 ; i++){
            if(grid[x+i][y] + grid[x+i][y+1] + grid[x+i][y+2] != s){
                return false;
            }
        }

        for(int i = 0 ; i < 3 ; i++){
            if(grid[x][y+i] + grid[x+1][y+i] + grid[x+2][y+i] != s){
                return false;
            }
        }

        if(grid[x][y] + grid[x+1][y+1] + grid[x+2][y+2] != grid[x][y+2] + grid[x+1][y+1] + grid[x+2][y]){
            return false;
        }

        return true;
    }
}