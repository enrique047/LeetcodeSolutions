//Max Sum of a Pair With Equal Sum of Digits
class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer , Integer> mp = new HashMap<>();

        int res = -1 , n = nums.length;

        for(int i = 0 ; i < n ; i++){
            int sum = getSum(nums[i]);

            if(mp.containsKey(sum)){
                res = Math.max(res , nums[i] + mp.get(sum));
            }

            mp.put(sum , Math.max(mp.getOrDefault(sum,0) , nums[i]));
        }

        return res;
    }

    public int getSum(int num){
        int ans = 0;

        while(num > 0){
            ans = ans + (num % 10);
            num = num / 10;
        }

        return ans;
    }
}