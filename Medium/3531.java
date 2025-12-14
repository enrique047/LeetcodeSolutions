//Count Covered Buildings
import java.util.*;
class Solution {
    public int countCoveredBuildings(int n, int[][] b) {
        HashMap<Integer, int[]> xToY = new HashMap<>();
        HashMap<Integer, int[]> yToX = new HashMap<>();

        for(int[] pts : b){
            int x = pts[0];
            int y = pts[1];

            if(xToY.containsKey(x)){
                int[] points = xToY.get(x);
                int minY = Math.min(points[0] , y);
                int maxY = Math.max(points[1] , y);
                xToY.put(x , new int[]{minY , maxY});
            }else{
                xToY.put(x , new int[]{y , y});
            }


            if(yToX.containsKey(y)){
                int[] points = yToX.get(y);
                int minX = Math.min(points[0] , x);
                int maxX = Math.max(points[1] , x);
                yToX.put(y , new int[]{minX , maxX});
            }else{
                yToX.put(y , new int[]{x , x});
            }
        }

        int res = 0;
        for(int[] pts : b){
            int x = pts[0];
            int y = pts[1];

            int[] xaxis = xToY.get(x);
            int[] yaxis = yToX.get(y);
            int minY = xaxis[0] , maxY = xaxis[1] , minX = yaxis[0] , maxX = yaxis[1];

            if( (minY < y && y < maxY) && (minX < x && x < maxX) ){
                res++;
            }
        }

        return res;
    }
}