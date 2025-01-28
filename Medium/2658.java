//Maximum Number of Fish in a Grid
class Solution {
    int n , m;
    int[][] dir = new int[][]{{1,0} , {-1,0} , {0,1} , {0,-1}};
    boolean[][] visited;

    public int findMaxFish(int[][] grid) {
        int max = 0;
        n = grid.length;
        m = grid[0].length;
        visited = new boolean[n][m];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] != 0 && !visited[i][j]){
                    max = Math.max( max , BFS(grid, i , j ));
                }
            }
        }
        return max;
    }

    public int BFS(int[][] grid , int i , int j ){

        int fish = grid[i][j];
        grid[i][j] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i , j});

        while(!q.isEmpty()){
            int[] cor = q.poll();
            int x = cor[0];
            int y = cor[1];

            for(int[] d : dir){
                int i_ = x + d[0];
                int j_ = y + d[1];

                if(i_ >= 0 && j_ >= 0 && i_ < n && j_ < m && grid[i_][j_] != 0  && !visited[i_][j_]){
                    fish += grid[i_][j_];
                    visited[i_][j_] = true;
                    q.offer(new int[]{i_ , j_});
                }
            }
        }
        
        return fish;
    }
}