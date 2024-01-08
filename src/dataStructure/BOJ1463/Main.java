package dataStructure.BOJ1463;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
X가 3으로 나누어 떨어지면, 3으로 나눈다.
X가 2로 나누어 떨어지면, 2로 나눈다.
1을 뺀다
*/
public class Main {
    static int[] D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        D = new int[n+1];
        D[1] = 0;
        for (int i = 2; i <= n ; i++) {
            int first = (i%3==0) ? D[i/3] : Integer.MAX_VALUE;
            int second = (i%2==0) ? D[i/2] : Integer.MAX_VALUE;
            int third = D[i-1];
            D[i] = Integer.min(Integer.min(first,second),third) + 1;
        }
        System.out.println(D[n]);

    }
}