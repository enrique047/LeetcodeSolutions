//Alternating Groups II
class Solution {
    public int numberOfAlternatingGroups(int[] color, int k) {
        int n = color.length;
        int N = n + (k - 1);
        int  j = 1 ; 
        int  i = 0 ;
        int res = 0;
        int[] colors = new int[N];
        
        int a = 0;
        for(; a < n ; a++){
            colors[a] = color[a];
        }

        int e  = 0 ;
        for(; a < N ; a++){
            colors[a] = color[e];
            e++;
        }



        while(j < N){
            if(colors[j] == colors[j - 1]){
                i = j ; 
                j++;
                continue;
            }

            if(j - i + 1 == k){
                res++;
                i++;
            }

            j++;
        }

        return res;
    }
}