//Find Eventual Safe States
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        boolean[] visited = new boolean[n];
        boolean[] inRecu = new boolean[n];

        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                isCycle(visited , inRecu , i ,graph);
            }
        }

        List<Integer> res = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++){
            if(inRecu[i] == false){
                res.add(i);
            }
        }

        return res;
    }

    public boolean isCycle(boolean[] visited , boolean[] inRecu , int u ,int[][] graph){
        visited[u] = true;
        inRecu[u] = true;

        for(int v : graph[u]){
            if(!visited[v] && isCycle(visited , inRecu , v ,graph)){
                return true;
            }else if(inRecu[v] == true){
                return true;
            }
        }
        
        inRecu[u] = false;
        return false;
    }
}