package dataStructure.BOJ1747;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int n = 10000000;
        boolean[] visited = new boolean[n+1];
        visited[1] = false;
        //visited 초기화
        for (int i = 2; i <= n; i++) {
            visited[i] = true;
        }
        //소수 구하기
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(!visited[i]) continue;
            for (int j = i+i; j <= n; j+=i) {
                visited[j] = false;
            }
        }
        //퍌린드롬 수 구하기
        for (int i = 2; i <= n ; i++) {
            if(visited[i]) {
                char[] value = String.valueOf(i).toCharArray();
                int start = 0;
                int end = value.length - 1;
                while(start < end) {
                    if(value[start] == value[end]) {
                        start ++;
                        end --;
                    } else {
                        visited[i] = false;
                        break;
                    }
                }
            }
        }
        for (int i = k; i <= n; i++) {
            if(visited[i]) {
                System.out.println(i);
                break;
            }
        }
    }
}