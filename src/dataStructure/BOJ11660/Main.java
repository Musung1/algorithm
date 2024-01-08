package dataStructure.BOJ11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//2,2
//3,4
//22,23,24
//32,33,34
//s[1][4] = s[1][3] + t[1][4]
//s[2][3] = s[1][3] + s[2][2] + t[2][3]
//s[3][4] = s[1][4] + s[2][4] + s[3][3] + t[3][4]
//s[3][1] = s[1][1] + s[2][1]  + s[3][1]
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[][] table = new int[n+1][n+1];
        int[][] ts = new int[n+1][n+1];
        int[][] S = new int [n+1][n+1];
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=n; j++){
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 부분 합 구하기
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                ts[i][j] = ts[i][j-1] + table[i][j];
                S[i][j] = S[i-1][j] + ts[i][j];
            }
        }
        for(int i = 0; i<q; i++){
            st = new StringTokenizer(br.readLine());
            int[] first = new int[2];
            int[] second = new int[2];
            int result = 0;
            first[0] = Integer.parseInt(st.nextToken());
            first[1] = Integer.parseInt(st.nextToken());
            second[0] = Integer.parseInt(st.nextToken());
            second[1] = Integer.parseInt(st.nextToken());

            result = S[second[0]][second[1]] - S[first[0]-1][second[1]] - S[second[0]][first[1]-1] + S[first[0]-1][first[1]-1];
            System.out.println(result);
        }
    }
}