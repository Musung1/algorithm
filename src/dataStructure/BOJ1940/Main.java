package dataStructure.BOJ1940;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] A = new int[n+1];
        int result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <=n ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int[] B = Arrays.stream(A).sorted().toArray();
        int first = 1;
        int last = n;
        while(first < last){
            if(B[first] + B[last] > m){
                last--;
            } else if (B[first] + B[last] < m) {
                first++;
            } else if (B[first] + B[last] == m) {
                first++;
                last--;
                result++;
            }
        }
        System.out.println(result);
    }
}