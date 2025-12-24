//Apple Redistribution into Boxes
import java.util.*;
class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int n = capacity.length;
        Arrays.sort(capacity);

        int appleSum = 0;

        for(int i : apple){
            appleSum += i;
        }

        int res = 0;

        for(int i = n - 1 ; i >= 0 ; i--){
            appleSum -= capacity[i];
            res++;

            if(appleSum <= 0) return res;
        }

        return res;
    }
}