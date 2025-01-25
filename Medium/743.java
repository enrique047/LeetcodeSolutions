//Network Delay Time
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer , List<int[]>> adj = new HashMap<>();

        for(int i = 1 ; i <= n ; i++){
            adj.put(i , new ArrayList<>());
        }

        for(int[] arr : times){
            int u = arr[0];
            int v = arr[1];
            int w = arr[2];

            adj.get(u).add(new int[]{v , w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[0]));

        pq.offer(new int[]{0 , k});

        int[] res = new int[n+1];
        Arrays.fill(res , Integer.MAX_VALUE);
        res[k] = 0;

        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int weight = temp[0];
            int u = temp[1];

            for(int[] t : adj.get(u)){
                int v = t[0];
                int w = t[1];

                if(weight + w < res[v]){
                    res[v] = weight + w;
                    pq.offer(new int[]{weight + w , v});
                }
            }
        }

        int result = 0 ;

        for(int i = 1 ; i <= n ; i++){
            if(res[i] == Integer.MAX_VALUE){
                return -1;
            }else{
                result = Math.max(result , res[i]);
            }
        }

        return result;

    }
}