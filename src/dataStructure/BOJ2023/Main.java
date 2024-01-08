package dataStructure.BOJ2023;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static LinkedList<Integer> result = new LinkedList<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        //1. 1의 자리 소수인지
        //2. 1,2 합쳐서 소수인지
        //3. 1,2,3 합쳐서 소수인지  -> 이런식으로 좁혀나가기
        //노드 계속 타고 가면서 소수인 것만 내려가기.. 소수가 아니면 return;
        DFS(num,1,0);
        result.forEach((value)-> System.out.println(value));
    }
    public static void DFS(int num, int cur, int prev) {
        int n = prev * 10;
        for (int i = 1; i < 10; i++) {
            if(isPrime(n+i)) {
                if(cur == num) {
                    result.add(n+i);
                } else {
                    DFS(num,cur+1,n+i);
                }
            }
        }

    }
    public static boolean isPrime(int n){
        if(n==1) return false;
        for (int i = 2; i <= Math.sqrt(n) ; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}