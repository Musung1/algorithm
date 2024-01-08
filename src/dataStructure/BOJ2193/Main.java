package dataStructure.BOJ2193;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
이친수는 0으로 시작하지 않는다.
이친수에서는 1이 두 번 연속으로 나타나지 않는다. 즉, 11을 부분 문자열로 갖지 않는다.
 */
public class Main {
    static long[] D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        D = new long[n+1];
        D[1] = 1;
        for (int i = 2; i <= n ; i++) {
            D[i] = D[i - 1] + D[i - 2];
        }
        System.out.println(D[n]);
    }
}