package dataStructure.BOJ2018;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] S = new int[n+1];
        int result = 0;
        for (int i = 1; i <= n ; i++) {
            S[i] = S[i-1] + i;
        }
        int first = 0;
        int last = 1;
        while(true){
            //1. n보다 작으면 last ++
            if(S[last] - S[first] < n) last++;
                //2. n이랑 같으면 result++ | first,last ++;
            else if(S[last] - S[first] == n){
                result++;
                first++;
                last++;
            }
            //3. n보다 크면 first ++
            else if(S[last] - S[first] > n) first++;
            if(last > n || first > n){
                break;
            }
        }

        System.out.println(result);
    }
}