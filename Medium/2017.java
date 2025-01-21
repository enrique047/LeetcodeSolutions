//Grid Game
class Solution {
    public long gridGame(int[][] grid) {
        long firstRowRemain = 0;

        for(int i = 0 ; i < grid[0].length ; i++){
            firstRowRemain = firstRowRemain + grid[0][i];
        }

        long secondRowRemain = 0;

        long minRobot2 = Long.MAX_VALUE;

        for(int R1 = 0 ; R1 <grid[0].length ; R1++){
            firstRowRemain = firstRowRemain - grid[0][R1];

            long bestRobot2 = Math.max(firstRowRemain ,secondRowRemain);

            minRobot2 = Math.min(minRobot2 ,bestRobot2);

            secondRowRemain = secondRowRemain + grid[1][R1];
        }

        return minRobot2;
    }
}