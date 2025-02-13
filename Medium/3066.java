//Minimum Operations to Exceed Threshold Value II
class Solution {
    public int minOperations(int[] nums, int k) {

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for(int i : nums){
            pq.offer((long)i);
        }
        
        int ans = 0;

        while(pq.size() > 1 ){

            if(pq.peek() >= k){
                break;
            }
            
            long x = pq.poll();
            long y = pq.poll();

            long num = x * 2 + y;

            pq.offer(num);

            ans++;
        }

        return ans;
    }
}