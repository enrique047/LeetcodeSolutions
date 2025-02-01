//Special Array I
class Solution {
    public boolean isArraySpecial(int[] nums) {
        var n = nums.length;
        for(var i = 1 ; i < n ; i++)
            if(nums[i] % 2 == nums[i - 1] % 2) return false;
        return true;
    }
}