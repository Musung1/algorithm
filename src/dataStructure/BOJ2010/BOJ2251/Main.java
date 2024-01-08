package dataStructure.BOJ2010.BOJ2251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] limit;
    static boolean[][][] visited;
    static int[] sender = new int[]{1,1,2,2,3,3};
    static int[] receiver = new int[]{2,3,1,3,1,2};
    static ArrayList<Integer> result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        int third = Integer.parseInt(st.nextToken());
        visited = new boolean[201][201][201];
        for (int i = 1; i <= 200 ; i++) {
            for (int j = 1; j <= 200 ; j++) {
                for (int k = 0; k <= 200 ; k++) {
                    visited[i][j][k] = false;
                }
            }
        }
        result = new ArrayList<>();
        limit = new int[]{0,first,second,third};
        int[] start = new int[]{0,0,0,third};
        BFS(start);
        Collections.sort(result);
        for(int i : result) {
            System.out.print(i);
            System.out.print(" ");
        }
        //1. 1->2, 1->3, 2->1, 2->3, 3->1, 3->2 가는 경로 모두 그래프에 넣어주기
        //1. 만약 start과 같아지면 끝!,

        // 주는 쪽이 0이면 안끝
        // 받는 쪽이 limit이면 x;
        // 주는쪽 + 받는 쪽이 받는쪽 limit보다 작으면 주는쪽 0
        // limit보다 크면 ,
    }
    static void BFS(int[] start) {
        Queue<int[]> queue = new LinkedList<>();
        visited[start[1]][start[2]][start[3]] = true;
        result.add(start[3]);
        queue.add(start);
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 6; i++) {
                int p1 = sender[i];
                int p2 = receiver[i];
                if(p1 != 0 && p2 != limit[p2]) {
                    int[] next = cur.clone();
                    int max = cur[p1] + cur[p2];
                    if(limit[p2] < max) {
                        next[p2] = limit[p2];
                        next[p1] = max - limit[p2];
                    } else {
                        next[p2] = max;
                        next[p1] = 0;
                    }
                    if (!visited[next[1]][next[2]][next[3]]) {
                        visited[next[1]][next[2]][next[3]] = true;
                        if(next[1] == 0) {
                            result.add(next[3]);
                        }
                        queue.add(next);
                    }
                }
            }
        }
    }
}

