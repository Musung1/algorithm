package dataStructure.BOJ10986;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] S = new long[n+1]; // 부분 합
        long[] store = new long[m]; // m까지 나머지 갯수
        long result = 0;

        for(int i = 1; i<=n; i++){
            S[i] = S[i-1] + Long.parseLong(st.nextToken());
            int remainder = (int) (S[i] % m);
            store[remainder]++;
            if(remainder == 0) result++;
        }
//        S[0] = Integer.parseInt(st.nextToken());
//        for(int i = 1; i< n; i++){
//            S[i] = S[i-1] +  Integer.parseInt(st.nextToken());
//        }
//        for(int i = 0; i< n; i++){
//            int remainder = (int) (S[i] % m);
//            if(remainder == 0) result++;
//            store[remainder]++;
//        }
        for (int i = 0; i < m ; i++) {
            if(store[i] > 1){
                result += (store[i]*(store[i] -1)/2);
            }
        }

        System.out.println(result);
    }
}