package dataStructure.BOJ3460;

import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new long[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= 11 ; i++) {
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }
        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(br.readLine());
            System.out.println(dp[k]);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)-> o2-o1);
    }
}
