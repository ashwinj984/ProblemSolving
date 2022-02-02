// O(nlogn) Approach
class Solution {
    public int lengthOfLIS(int[] nums) {
        int max = 0;
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        for(int i = 0; i < n; i++){
            int pos = findPosition(dp, nums[i], i);
            
            dp[pos] = nums[i];
            if(max < pos){
                max = pos;
            }
            
        }
        return max + 1;
    }
    // binary search algo
    public int findPosition(int[] dp, int target, int hi){
        int lo = 0;
        while(lo<=hi){
            int mid = (lo + hi) / 2;
            if(target == dp[mid]){
                return mid;
            }else if(target < dp[mid]){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        return lo;
    }
}
