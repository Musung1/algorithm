package dataStructure.BOJ1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int num;
    static int[][] D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = Integer.parseInt(st.nextToken());
        D = new int[30][30];
        for (int i = 1; i < 30; i++) {
            D[i][1] = 1;
        }
        for (int i = 1; i < 30; i++) {
            D[1][i] = i;
        }
        //D[i][j] = D[i-1][i-1] +... D[i-1][j-1]
        for (int i = 2; i < 30; i++) {
            for (int j = 1; j < 30; j++) {
                for (int k = i-1; k < j ; k++) {
                    D[i][j] += D[i-1][k];
                }
            }
        }
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            System.out.println(D[n][m]);
        }

    }
}