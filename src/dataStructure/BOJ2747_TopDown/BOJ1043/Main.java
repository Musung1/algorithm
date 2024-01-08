package dataStructure.BOJ2747_TopDown.BOJ1043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        D = new int[n+1];
        for (int i = 0; i <= n ; i++) {
            D[i] = -1;
        }
        D[0] = 0;
        D[1] = 1;
        fibo(n);
        System.out.println(D[n]);

    }
    static int fibo(int n) {
        if(D[n] != -1) return D[n];
        return D[n] = fibo(n-2) + fibo(n-1);
    }
}