package dataStructure.BOJ1915;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[][] map;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new int[n+1][m+1];
        map = new int[n+1][m+1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 1; j <= m ; j++) {
                map[i][j] = Character.getNumericValue(str[j-1]);
                if(map[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    int x = Integer.min(Integer.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1]);
                    dp[i][j] = x+1;
                    if(max < x+1) {
                        max = x+1;
                    }
                }
            }
        }
        System.out.println(max*max);

    }
}
