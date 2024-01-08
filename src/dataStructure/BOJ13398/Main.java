package dataStructure.BOJ13398;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list = new int[n];
        int[] L = new int[n];
        int[] R = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        L[0] = list[0];
        R[n-1] = list[n-1];
        int result = L[0];
        for (int i = 1; i < n; i++) {
            L[i] = Integer.max(list[i] , L[i-1] + list[i]);
            result = Integer.max(result,L[i]);
        }
        for (int i = n-2; i >= 0 ; i--) {
            R[i] = Integer.max(list[i], R[i+1] + list[i]);
            result = Integer.max(result,R[i]);
        }
        if(n > 1) {
            for (int i = 0; i < n; i++) {
                if(i == 0) {
                    result = Integer.max(result, Integer.max(R[i+1], R[i+1] + list[i]));
                }
                else if(i == n-1) {
                    result = Integer.max(result, Integer.max(L[i-1], L[i-1] + list[i]));
                } else {
                    result = Integer.max(result, Integer.max(L[i-1] + R[i+1], L[i-1] + R[i+1] + list[i]));
                }
            }
        }
        System.out.println(result);
    }
}
// 왼쪽부터 n을 포함하는 수열의 최대 L[n]
// 오른쪽부터 n을 포함하는 수열의 최대 R[n]
// Integer.max(L[n-1] + R[n-1], L[n-1] + R[n-1] + list[n])이 최대인 값 구하기