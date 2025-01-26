//Maximum Employees to Be Invited to a Meeting
class Solution {
    public int maximumInvitations(int[] f) {
        int n = f.length;
        HashMap<Integer , List<Integer>> adj = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            adj.put(i , new ArrayList<>());
        }

        for(int i = 0 ; i < n ; i++){
            int u = i ;
            int v = f[i];

            adj.get(v).add(u);
        }

        int longestCycle = 0 , happyCouple = 0;

        boolean[] visited = new boolean[n];

        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                HashMap<Integer , Integer> mp = new HashMap<>();

                int curNode = i;
                int curNodeCnt = 0;

                while(!visited[curNode]){
                    visited[curNode] = true;
                    mp.put(curNode , curNodeCnt);

                    int nextNode = f[curNode];
                    curNodeCnt++;

                    if(mp.containsKey(nextNode)){
                        int cycleLength = curNodeCnt - mp.get(nextNode);
                        longestCycle = Math.max(longestCycle , cycleLength);
                        if(cycleLength == 2){
                            boolean[] visitedNode = new boolean[n];
                            visitedNode[curNode] = true;
                            visitedNode[nextNode]= true;
                            happyCouple += 2 + BFS(curNode , adj , visitedNode) + BFS(nextNode , adj , visitedNode);
                        }
                        break;
                    }
                    curNode = nextNode;
                }
            }
        }

        return Math.max(happyCouple , longestCycle);
    }

    public int BFS(int start , HashMap<Integer , List<Integer>> adj , boolean[] visited){
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{start , 0});
        int maxDistance = 0;

        while(!q.isEmpty()){
            int[] t = q.poll();
            int curr = t[0] , dist = t[1];

            for(int v : adj.get(curr)){
                if(!visited[v]){
                    visited[v] = true;
                    q.offer(new int[]{v , dist + 1});
                    maxDistance = Math.max(maxDistance , dist + 1);
                }
            }
        }

        return maxDistance;
    }
}