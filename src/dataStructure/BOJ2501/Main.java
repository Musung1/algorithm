package dataStructure.BOJ2501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // n의 약수 중 k번째 수
    // k번째 약수 존재하지 않으면 0
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        System.out.println(findDivisor(n,k));
    }
    public static int findDivisor(int n, int k) {
        int index = 0;
        for(int i = 1; i <= n; i++) {
            if(n%i == 0) {
                index++;
                if(index == k) return i;
            }
        }
        return 0;
    }
}