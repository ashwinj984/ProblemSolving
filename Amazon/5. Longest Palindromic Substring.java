class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int si = 0;
        int ei = 0;
        for(int g = 0; g < s.length(); g++){
            for(int i = 0, j = g; j < n; j++,i++){
                if(g == 0){
                    dp[i][j] = true;
                }else if(g == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }else {
                    if(s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = false;
                    }
                }
                
                if(dp[i][j]){
                    si = i;
                    ei = j;
                }
            }
        }
        return s.substring(si, ei + 1);
    }
}
