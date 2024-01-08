package dataStructure.BOJ14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int[][] table;
    static int n;
    static int[] D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        table = new int[n+1][2];
        D = new int[n+1];
        for (int i = 1; i <= n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            table[i][0] = t;
            table[i][1] = p;
        }
        for (int i = n; i >= 1 ; i--) {
            if(i + table[i][0] <= n+1) {
                for (int j = i + table[i][0]; j <= n ; j++) {
                    D[i] = Integer.max(D[i],D[j]);
                }
                D[i] += table[i][1];
            }
        }
        int result = 0;
        for (int i = 1; i <= n ; i++) {
            result = Integer.max(result,D[i]);
        }
        System.out.println(result);
    }
}