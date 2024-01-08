package dataStructure.BOJ1456;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        int sqrtMax = (int) Math.sqrt(max);
        boolean[] prime = new boolean[sqrtMax+1];

        // 소수 초기화
        for (int i = 2; i <= sqrtMax ; i++) {
            prime[i] = true;
        }
        //제곱근 까지 소수 구하기
        for (int i = 2; i <= sqrtMax; i++) {
            if(!prime[i]) continue;
            for (int j = i+i; j <= sqrtMax ; j+=i) {
                prime[j] = false;
            }
        }

        int count = 0;
        for (int i = 2; i <= sqrtMax ; i++) {
            if(prime[i]) {
                long cur = i;
                while((double)i <= (double)max/(double)cur) {
                    if((double)i >= (double)min/(double) cur) {
                        count ++;
                    }
                    cur *= i;
                }
            }
        }
        System.out.println(count);
    }
}