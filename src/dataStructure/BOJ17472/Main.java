package dataStructure.BOJ17472;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        // 입력 받기
        for (int i = 1; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // bfs로 섬 구분 해주기 , 섬 갯수 세기
        int islandNum = 2;
        int islandCount = 0;
        for (int i = 1; i <= N ; i++) {
            for (int j = 1; j <= M ; j++) {
                if (map[i][j] == 1) {
                    BFS(new int[]{i,j},islandNum++);
                    islandCount++;
                }
            }
        }
    }
    static void BFS(int[] location, int num){
        // 상 하 좌 우 탐색, 원하는
        int[] y = new int[]{-1,1,0,0};
        int[] x = new int[]{0,0,-1,1};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(location);
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                if (map[cur[0] + y[i]][cur[1] + x[i]] == 1) {
                    map[cur[0] + y[i]][cur[1] + x[i]] = num;
                    queue.add(new int[]{cur[0] + y[i],cur[1] + x[i]});
                }
            }
        }
    }

}