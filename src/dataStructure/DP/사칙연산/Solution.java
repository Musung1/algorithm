package dataStructure.DP.사칙연산;

import java.lang.Math;
class Solution {
    public int solution(String arr[]) {
        int[] num = new int[arr.length / 2 + 1];
        int[] op = new int[arr.length / 2];      //0 : +, 1: -
        int ind1 = 0;
        int ind2 = 0;
        for (String cur : arr) {
            if (cur.equals("+"))
                op[ind2++] = 0;
            else if (cur.equals("-"))
                op[ind2++] = 1;
            else
                num[ind1++] = Integer.parseInt(cur);
        }
        int[][][] dp = new int[arr.length / 2 + 1][arr.length / 2 + 1][2];

        for (int i = 0; i < arr.length / 2 + 1; i++)
            dp[i][i][0] = dp[i][i][1] = num[i];

        for(int len = 1; len < arr.length /2 + 1; len++) {
            for(int s = 0; s < arr.length /2 + 1; s++) {
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                int e = s + len;
                if (e > arr.length/2) break;
                for(int i = s; i < e ; i++) {
                    if(op[i] == 0) {
                        max = Math.max(dp[s][i][0] + dp[i+1][e][0],max);
                        min = Math.min(dp[s][i][1] + dp[i+1][e][1],min);
                    }
                    if(op[i] == 1) {
                        max = Math.max(dp[s][i][0] - dp[i+1][e][1],max);
                        min = Math.min(dp[s][i][1] - dp[i+1][e][0],min);
                    }
                }
                dp[s][e][0] = max;
                dp[s][e][1] = min;
            }
        }
        return dp[0][arr.length/2][0];
    }
}
