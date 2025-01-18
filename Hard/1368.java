//Minimum Cost to Make at Least One Valid Path in a Grid
class Solution {
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minCost(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));

        int m = grid.length;
        int n = grid[0].length;

        int[][] result = new int[m][n];

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                result[i][j] = Integer.MAX_VALUE;
            }
        }

        pq.offer(new int[]{0 , 0 ,0});

        result[0][0] = 0;

        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            int curCost = arr[0];
            int i = arr[1];
            int j = arr[2];

            

            for(int t = 0 ; t <= 3 ; t++){
                int i_ = i + dir[t][0];
                int j_ = j + dir[t][1];

                if(i_ >= 0 && j_ >= 0 && i_ < m && j_ < n){
                    int gridDir = grid[i][j];
                    int dirCost = (gridDir -1 != t ? 1 : 0);

                    int newCost = curCost + dirCost;

                    if(newCost < result[i_][j_]){
                        result[i_][j_] = newCost;
                        pq.offer(new int[]{newCost , i_ , j_});
                    }
                }
            }
        }

        return result[m-1][n-1];
    }
}