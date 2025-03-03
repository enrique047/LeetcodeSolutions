//Partition Array According to Given Pivot
class Solution {
    public int[] pivotArray(int[] nums, int p) {
        
        int cnt = 0;
        int j = 0 ;
        int n = nums.length;

        int[] res = new int[n];

        for(int i : nums){
            if(i < p ){
                res[j++] = i;
            }else if(i == p){
                cnt++;
            }
        }

        while(cnt-- > 0){
            res[j++] = p;
        }

        for(int i : nums){
            if(i > p ){
                res[j++] = i;
            }
        }
        
        return res;
    }
}