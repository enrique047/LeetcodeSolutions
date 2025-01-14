//Find the Prefix Common Array of Two Arrays
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashMap<Integer , Integer> mp = new HashMap<>();
        int n = A.length , cnt = 0;

        int[] arr = new int[n];

        for(int i = 0 ; i < n ; i++){
            mp.put(A[i] , mp.getOrDefault(A[i] , 0) + 1);

            if(mp.get(A[i]) == 2){
                cnt++;
            }

            mp.put(B[i] , mp.getOrDefault(B[i] , 0) + 1);

            if(mp.get(B[i]) == 2){
                cnt++;
            }

            arr[i] = cnt;
        }

        return arr;
    }
}