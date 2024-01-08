package dataStructure.BOJ1328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n,l,r;
    static long[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        dp = new long[n+1][l+1][r+1];

        //1. 가장 작은 수를 왼쪽에 배치하는 경우의 수
        // dp[n-1][l-1][r]
        //2. 가장 작은 수를 오른쪽에 배치는 경우의 수
        // dp[n-1][l][r-1]
        //3. 가장 작은 수를 가운데 배치하는 경우의 수
        // dp[n-1][l][r]*(n-2)

        dp[1][1][1] = 1;
        for (int i = 2; i <= n ; i++) {
            for (int j = 1; j <= l ; j++) {
                for (int k = 1; k <= r; k++) {
                    dp[i][j][k] = (
                            dp[i-1][j-1][k] +
                            dp[i-1][j][k-1] +
                            dp[i-1][j][k]*(i-2)
                    ) % 1000000007;
                }
            }
        }
        System.out.println(dp[n][l][r]);

    }
}