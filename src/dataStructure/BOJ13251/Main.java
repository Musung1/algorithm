package dataStructure.BOJ13251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int m,n,k;
    static int[] colors;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(br.readLine());
        colors = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            colors[i] = Integer.parseInt(st.nextToken());
        }
        n = Integer.parseInt(br.readLine())*m;
        k = Integer.parseInt(br.readLine());



    }
}