//Maximize Happiness of Selected Children
import java.util.*;
class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for(int i : happiness){
            maxHeap.offer(i);
        }

        long res = 0 , neg = 0;

        while(k > 0){
            int curr = maxHeap.poll();

            if(curr - neg > 0){
                res += (curr - neg);
            }

            neg++;
            k--;
        }

        return res;
    }
}