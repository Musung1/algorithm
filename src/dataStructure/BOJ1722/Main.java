package dataStructure.BOJ1722;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] factorialList;
    static int[] result;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        factorialList = new int[n+1];
        result = new int[n+1];
        visited = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            if(i == 1) {
                factorialList[i] = 1;
            } else {
                factorialList[i] = i * factorialList[i-1];
            }
        }
        st = new StringTokenizer(br.readLine());
        int pNum = Integer.parseInt(st.nextToken());

        if(pNum == 1) {
            int dest = Integer.parseInt(st.nextToken());
            for (int i = n; i >= 1 ; i--) {
                int num = 1;
                for (int j = 1; j <= i; j++) {
                    if(dest <= factorialList[i-1]*j) {
                        num = j;
                        dest -= factorialList[i-1]*(j-1);
                        break;
                    }
                }
                int count = 0;
                for (int k = 1; k <= n ; k++) {
                    if(visited[k]) continue;
                    count++;
                    if(count == num) {
                        visited[k] = true;
                        result[i] = k;
                    }
                }
            }
            for (int i = 4; i > 0 ; i--) {
                System.out.print(result[i] + " ");
            }
        }else {
            int result = 0;
            for (int i = 1; i <= n; i++) {
                visited[i] = false;
            }
            int[] temp = new int[n+1];
            for (int i = 1; i <= n; i++) {
                temp[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i <= n ; i++) {
                int count = 0;
                for (int j = 1; j <= temp[i]; j++) {
                    if(visited[j]) continue;
                    count++;
                }
                visited[temp[i]] = true;
                //System.out.println(count);
                if(i == n) {
                    result += count;
                } else {
                    result += factorialList[n-i] * (count-1);
                }
            }
            System.out.println(result);
        }
    }
}