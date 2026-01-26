//2092. Find All People With Secret

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Solution {

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Map<Integer, List<int[]>> map = new TreeMap<>();

        for (int[] meet : meetings) {
            int v = meet[0];
            int u = meet[1];
            int time = meet[2];

            map.computeIfAbsent(time, k -> new ArrayList<>()).add(new int[] { v, u });
        }

        boolean[] knowsSecret = new boolean[n];
        knowsSecret[0] = true;
        knowsSecret[firstPerson] = true;

        for (Integer time : map.keySet()) {
            List<int[]> t = map.get(time);

            Queue<Integer> q = new LinkedList<>();
            Map<Integer, List<Integer>> adj = new HashMap<>();
            HashSet<Integer> alreadyAdded = new HashSet<>();

            for (int[] temp : t) {
                int person1 = temp[0];
                int person2 = temp[1];

                adj.computeIfAbsent(person1, k -> new ArrayList<>()).add(person2);
                adj.computeIfAbsent(person2, k -> new ArrayList<>()).add(person1);

                if (knowsSecret[person1] && !alreadyAdded.contains(person1)) {
                    q.offer(person1);
                    alreadyAdded.add(person1);

                }

                if (knowsSecret[person2] && !alreadyAdded.contains(person2)) {
                    q.offer(person2);
                    alreadyAdded.add(person2);

                }
            }

            while (!q.isEmpty()) {
                int person = q.poll();

                for (int i : adj.get(person)) {
                    if (!knowsSecret[i]) {
                        knowsSecret[i] = true;
                        q.offer(i);
                    }
                }
            }
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (knowsSecret[i]) {
                res.add(i);
            }
        }

        return res;
    }
}