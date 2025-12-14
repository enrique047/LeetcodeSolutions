//Count Mentions Per User
import java.util.*;
class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] count = new int[numberOfUsers];
        int[] offLine = new int[numberOfUsers];

        Collections.sort( events , (a,b) -> {
            int t1 = Integer.parseInt(a.get(1));
            int t2 = Integer.parseInt(b.get(1));

            if (t1 == t2) {
                char c1 = a.get(0).charAt(1);
                char c2 = b.get(0).charAt(1);

                if (c1 > c2) return -1;
                if (c1 < c2) return 1;
                return 0;
            }

            return Integer.compare(t1, t2);
        });

        for(List<String> t : events){

            if(t.get(0).equals("MESSAGE")){
                int timeStamp = Integer.parseInt(t.get(1));

                if(t.get(2).equals("ALL")){

                    for(int i = 0 ; i < numberOfUsers ; i++){
                        count[i]++;
                    }

                }else if(t.get(2).equals("HERE")){
                    
                    for(int i = 0 ; i < numberOfUsers ; i++){
                        if(offLine[i] == 0 || timeStamp >= offLine[i] + 60){
                            count[i]++;
                        }
                    }
                }else{
                    String[] tk = t.get(2).split(" ");

                    for(int i = 0 ; i < tk.length ; i++){
                        int id = Integer.parseInt(tk[i].substring(2));
                        count[id]++;

                    }
                }
            }else{
                int id = Integer.parseInt(t.get(2));
                int timeStamp = Integer.parseInt(t.get(1));
                offLine[id] = timeStamp;
            }
        }

        return count;
    }
}