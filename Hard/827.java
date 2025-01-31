//Making A Large Island
class Solution {
    int[][] dir = new int[][]{{1,0} , {-1,0} , {0,1} , {0,-1}};
    int n ,m;

    public int largestIsland(int[][] grid) {
        HashMap<Integer , Integer> str = new HashMap<>();
        int id = 2;
        n = grid.length;
        m = grid[0].length;

        int maxAns = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    int area = DFS(grid , i , j , id);
                    str.put(id , area);
                    id++;
                }
            }
        }


        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 0){
                    int ans = 0;
                    Set<Integer> island = new HashSet<>();

                    for(int[] d : dir){
                        int i_ = i + d[0];
                        int j_ = j + d[1];
                        
                        if(i_ >= 0 && j_ >= 0 && i_ < n && j_ < m && grid[i_][j_] != 0){
                            island.add(grid[i_][j_]);
                        }
                    }

                    for(int k : island){
                        ans = ans + str.get(k);
                    }

                    maxAns = Math.max(maxAns , ans + 1);
                }
            }
        }

        return maxAns == 0 ? n*m : maxAns;
    }

    public int DFS(int[][] grid , int i , int j , int id){
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != 1){
            return 0;
        }

        int areaMax = 1;
        grid[i][j] = id;
        
        for(int[] d : dir){
            int i_ = i + d[0];
            int j_ = j + d[1];

            areaMax += DFS(grid , i_ , j_ ,id);
        }

        return areaMax;
    }
}