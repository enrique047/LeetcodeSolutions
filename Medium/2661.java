//First Completely Painted Row or Column
class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        HashMap<Integer , int[]> mp = new HashMap<>();

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                mp.put(mat[i][j] , new int[]{i , j});
            }
        }

        int result = 0;

        int[] rowPos = new int[m];
        int[] colPos = new int[n];

        for(int i = 0 ; i < m * n ; i++){
            int[] position = mp.get(arr[i]);
            int row = position[0];
            int col = position[1];

            rowPos[row]++;
            colPos[col]++;

            if(rowPos[row] == n || colPos[col] == m){
                return i;
            }
        }

        return result;
    }
}