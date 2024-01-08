package dataStructure.BOJ10844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[][] D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        D = new long[n+1][10];
        for (int i = 1; i <= 9 ; i++) {
            D[1][i] = 1;
        }
        for (int i = 2; i <= n ; i++) {
            for (int j = 0; j <= 9 ; j++) {
                long before = (j-1 >= 0)? D[i-1][j-1] : 0;
                long after = (j+1 < 10)? D[i-1][j+1] : 0;
                D[i][j] =(before + after)  % 1000000000;
            }
        }
        long result = 0;
        for (int i = 0; i <= 9 ; i++) {
            result = (result + D[n][i])  % 1000000000;
        }
        System.out.println(result);
    }

}