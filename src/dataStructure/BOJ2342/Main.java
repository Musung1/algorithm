package dataStructure.BOJ2342;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> step;
    static int[][][] dp;
    static int n;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0,};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        step = new ArrayList<>();
        while(true) {
            int k = Integer.parseInt(st.nextToken());
            if(k == 0) break;
            step.add(k);
        }
        n = step.size();
        dp = new int[n+1][5][5];
        //1. 시작은 0,0
        //2. 두 발 같은지점 X, 두 발 동시에 x
        //3. 같은 지역 (1)
        //4. 중앙 -> 다른지점 (2)
        //5. 인접지역 (3)
        //6. 나머지 (4)
        for (int i = 1; i <=4 ; i++) {
            dp[1][i][0] = 1;
            dp[1][0][i] = 1;
        }
        //왼발 목적지
        for (int i = 2; i <= n ; i++) {
            int dest = step.get(i-1);
            for (int j = 0; j <= 4 ; j++) {
                if(dest == j) continue;
                int dest2 = step.get(i-2);
                for (int k = 0; k <= 4 ; k++) {
                    if(dest2 == k) continue;
                    int a = Integer.MAX_VALUE;
                    int b = Integer.MAX_VALUE;
                    if(dp[i-1][dest2][k] != 0) {
                        if(dest2 == dest) a = dp[i-1][dest2][k] + 1; // +1
                        else if(dest2 == 0) a = dp[i-1][dest2][k] + 2; // +2
                        else if(Math.abs(dest-dest2) == 1) a = dp[i-1][dest2][k] + 3; // +3
                        else a = dp[i-1][dest2][k] + 4; // +4
                    }
                    if(dp[i-1][k][dest2] != 0) {
                        if(k == dest) b = dp[i-1][k][dest2] + 1; // +1
                        else if(k == 0) b = dp[i-1][k][dest2] + 2; // +2
                        else if(Math.abs(dest-k) == 1) b = dp[i-1][k][dest2] + 3; // +3
                        else b = dp[i-1][k][dest2] + 4; // +4
                    }
                    if(a != Integer.MAX_VALUE || b != Integer.MAX_VALUE) {
                        dp[i][dest][j] = Integer.min(a,b);
                    }

                    //dp[i-1][dest2][k]
                    //dp[i-1][k][dest2] 의 최솟값
                }
            }
        }
        for (int i = 2; i <= n ; i++) {
            int dest = step.get(i-1);
            for (int j = 0; j <= 4 ; j++) {
                if(dest == j) continue;
                int dest2 = step.get(i-2);
                int a = Integer.MAX_VALUE;
                int b = Integer.MAX_VALUE;
                for (int k = 0; k <= 4 ; k++) {
                    if(dest2 == k) continue;
                    if(dp[i-1][dest2][k] != 0) {
                        if(k == dest) a = dp[i-1][dest2][k] + 1; // +1
                        else if(k == 0) a = dp[i-1][dest2][k] + 2; // +2
                        else if(Math.abs(dest-k) == 1) a = dp[i-1][dest2][k] + 3; // +3
                        else a = dp[i-1][dest2][k] + 4; // +4
                    }

                    if(dp[i-1][k][dest2] != 0) {
                        if(dest2 == dest) b = dp[i-1][k][dest2] + 1; // +1
                        else if(dest2 == 0) b = dp[i-1][k][dest2] + 2; // +2
                        else if(Math.abs(dest-dest2) == 1) b= dp[i-1][k][dest2] + 3; // +3
                        else b = dp[i-1][k][dest2] + 4; // +4
                    }
                    if(a != Integer.MAX_VALUE || b != Integer.MAX_VALUE) {
                        dp[i][j][dest] = Integer.min(a,b);
                    }
                    //dp[i-1][dest2][k]
                    //dp[i-1][k][dest2] 의 최솟값
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int dest = step.get(n-1);
        for (int i = 0; i <= 4 ; i++) {
            for (int j = 0; j <=4 ; j++) {
                if(i == j) continue;
                if(i == dest || j == dest ) {
                    System.out.println(i + " ," + j + " 번째 : " + dp[n][i][j]);
                    if(min > dp[n][i][j]) {
                        min = dp[n][i][j];
                    }
                }
            }
        }
        System.out.println(min);
        // 왼발이 목적지일 경우
        //dp[n][k][?] = dp[n-1]의 왼,오른쪽 둘 중 하나가 목적이일 경우
        // 오른발이 목적지일 경우
        //dp[n][?][k] =
    }
}