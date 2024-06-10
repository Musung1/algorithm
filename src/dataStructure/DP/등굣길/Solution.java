package dataStructure.DP.등굣길;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class Solution {
    static int[][] dp;
    static int x;
    static int y;
    static int mod = 1000000007;
    public int solution(int m, int n, int[][] puddles) {
        dp = new int[m+1][n+1];
        dp[1][1] = 1;
        for(int[] water : puddles) {
            dp[water[0]][water[1]] = -1;
        }
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == 1 && j ==1) continue;
                if(dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % mod;
            }
        }
        int answer = dp[m][n] % mod;
        return answer;
    }
}