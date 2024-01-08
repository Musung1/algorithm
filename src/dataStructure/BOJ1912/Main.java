package dataStructure.BOJ1912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = list[0];
        //n 번까지의 최대
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.max(list[i],dp[i-1] + list[i]);
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            result = Integer.max(result,dp[i]);
        }
        System.out.println(result);
    }
}