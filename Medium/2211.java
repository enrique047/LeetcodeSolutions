//Count Collisions on a Road
class Solution {
    public int countCollisions(String d) {
        int res = 0;
        int n = d.length();
        int i = 0 , j = n - 1;

        while(i < n && d.charAt(i) == 'L'){
            i++;
        }

        while(j >= 0 && d.charAt(j) == 'R'){
            j--;
        }

        while(i <= j){
            if(d.charAt(i) == 'L' || d.charAt(i) == 'R'){
                res++;
            }
            i++;
        }

        return res;
    }
}