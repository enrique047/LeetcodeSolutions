//Minimum Genetic Mutation
class Solution {
    public int minMutation(String startGene, String endGene, String[] b) {
        Queue<String> q = new LinkedList();
        Set<String> bank = new HashSet<>(Arrays.asList(b));

        Set<String> visited = new HashSet<>();

        q.offer(startGene);
        visited.add(startGene);
        int level = 0;

        while(!q.isEmpty()){
            int size = q.size();

            while(size-- > 0){
                String curr = q.poll();

                if(curr.toString().equals(endGene)){
                    return level;
                }

                for(char ch : "ACGT".toCharArray()){

                    for(int i = 0 ; i < curr.length() ; i++){
                        StringBuilder neighbour = new StringBuilder(curr);
                        neighbour.setCharAt(i, ch);

                        if(!visited.contains(neighbour.toString()) && bank.contains(neighbour.toString())){
                            visited.add(neighbour.toString());
                            q.offer(neighbour.toString());
                        }
                    }
                }
            }

            level++;
        }

        return -1;
    }
}