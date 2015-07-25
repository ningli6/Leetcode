/* DP method
*/
boolean isMatch(String s, String p) 
{  
    if(p.length() == 0) return s.length() == 0;  
    int m = s.length();  
    int n = p.length();  
    boolean[][] dp = new boolean[m + 1][n + 1];  
    dp[0][0] = true;  
    for(int j = 0; j < n; j++) 
    {
        if(p.charAt(j) != '*') 
        {
            for(int i = 0; i < m; i++) 
            {  
                dp[i + 1][j + 1] = dp[i][j] && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?');  
            }
        } 
        else
        {  
            int i = 0;  
            while(i < s.length() && !dp[i][j]) i++;  
            for(; i < m; i++) dp[i][j] = true;  
        }  
    }  
    return dp[m][n];  
}