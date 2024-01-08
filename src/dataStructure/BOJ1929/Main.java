package dataStructure.BOJ1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[] A = new boolean[m+1];
        int max = (int) Math.sqrt(m);

        for (int i = 2 ; i <= m; i++) {
            A[i] = true;
        }

        for (int i = 2; i <= max; i++) {
            for (int j = i+i; j <= m; j+=i) {
                A[j] = false;
            }
        }
        for (int i = n; i <= m; i++) {
            if(A[i]) System.out.println(i);
        }
    }
}