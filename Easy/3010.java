//Divide an Array Into Subarrays With Minimum Cost I
class Solution {
    public int minimumCost(int[] nums) {
        int minEle1 = Integer.MAX_VALUE, minEle2 = Integer.MAX_VALUE;
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            if (minEle1 > nums[i]) {
                minEle2 = minEle1;
                minEle1 = nums[i];
            } else if (nums[i] < minEle2) {
                minEle2 = nums[i];
            }
        }

        return nums[0] + minEle1 + minEle2;
    }
}