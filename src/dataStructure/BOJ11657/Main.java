package dataStructure.BOJ11657;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int n;
    static int m;
    static ArrayList<Edge>[] list;
    static long[] distance;
    static long[] checkDistance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        distance = new long[n+1];
        for (int i = 1; i <= n ; i++) {
            distance[i] = Long.MAX_VALUE;
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(v,e));
        }
        distance[1] = 0;
        // 시작 = 1;
        // 벨만 포드 알고리즘으로 출력
        for (int i = 1; i <= n ; i++) {
            // 1. distance에서 0이 아닌 노드 찾기
            if(i == n) {
                checkDistance = distance.clone();
            }
            ArrayList<Integer> aNum = new ArrayList<>();
            for (int j = 1; j <= n ; j++) {
                if(distance[j] != Long.MAX_VALUE) {
                    aNum.add(j);
                }
            }
            for (int j : aNum) {
                for ( Edge edge: list[j]) {
                    distance[edge.vertex] = Long.min(distance[edge.vertex],distance[j] + edge.value);
                }
            }
            if(i == n) {
                if(Arrays.equals(checkDistance,distance)) {
                    for (int j = 2; j <= n ; j++) {
                        if(distance[j] != Long.MAX_VALUE) {
                            System.out.println(distance[j]);
                        } else {
                            System.out.println("-1");
                        }
                    }
                } else {
                    System.out.println("-1");
                }
            }
        }


    }
    static class Edge {
        int vertex;
        int value;
        public Edge(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }
    }

}