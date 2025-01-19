//Trapping Rain Water II
class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        boolean[][] visited = new boolean[m][n];

        for(int row = 0 ; row < m ; row++){
            pq.offer(new int[]{heightMap[row][0], row, 0});
            visited[row][0] = true;
            pq.offer(new int[]{heightMap[row][n - 1], row, n - 1});
            visited[row][n - 1] = true;
        }

        for (int col = 0; col < n; col++) {
            pq.offer(new int[]{heightMap[0][col], 0, col});
            visited[0][col] = true;
            pq.offer(new int[]{heightMap[m - 1][col], m - 1, col});
            visited[m - 1][col] = true;
        }

        int water = 0;

        int[][] directions = {{0,-1} , {0 , 1} , {1 , 0} , {-1 , 0}};

        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            int height = arr[0];
            int i = arr[1];
            int j = arr[2];

            for(int[] d : directions){
                int i_ = i + d[0];
                int j_ = j + d[1];

                if(i_ >= 0 && j_ >= 0 && i_ < m && j_ < n && !visited[i_][j_]){
                    water = water + Math.max(height - heightMap[i_][j_] , 0);

                    pq.offer(new int[]{Math.max(height , heightMap[i_][j_]) , i_ ,j_});
                    visited[i_][j_] = true;
                }
            }
        }


        return water;
    }
}