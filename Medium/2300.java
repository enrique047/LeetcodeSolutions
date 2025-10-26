//Successful Pairs of Spells and Potions
import java.util.*;
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);

        int n = spells.length , m = potions.length;
        int[] res = new int[n];

        for(int i = 0 ; i < n ; i++){
            long minPotion = (long)Math.ceil((1.0 * success) / spells[i]);

            if(minPotion > potions[m-1]){
                res[i] = 0;
                continue;
            }

            int idx = lowerBound(potions , minPotion);

            res[i] = m - idx ;
        }

        return res;
    }

    public int lowerBound(int[] p , long target){
        int start = 0 , end = p.length ;

        while(start < end){
            int mid = start + (end - start) / 2 ;

            if(p[mid] < target){
                start = mid + 1;
            }else{
                end = mid;
            }
        }

        return start;
    }
}