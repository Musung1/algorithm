package dataStructure.BOJ11689;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long result = n;
        for(long p = 2; p <= Math.sqrt(n); p++) {
            if(n % p == 0) {
                result = result - result / p;
                while(n % p == 0) {
                    n /= p;
                }
            }
        }
    }
}