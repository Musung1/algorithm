package dataStructure.BOJ11404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Main {
    static int n;
    static int m;
    static ArrayList<Edge>[] list;
    static long[][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        distance = new long[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            list[start].add(new Edge(end,value));
        }
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                if(i == j) {
                    distance[i][j] = 0;
                    continue;
                }
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i <= n ; i++) {
            for(Edge edge : list[i]) {
                if(distance[i][edge.vertex] > edge.value)  distance[i][edge.vertex] = edge.value;
            }
        }
        for (int k = 1; k <= n; k++) {
            for (int s = 1; s <= n; s++) {
                for (int e = 1; e <= n; e++) {
                    distance[s][e] = Math.min(distance[s][e],distance[s][k] + distance[k][e]);
                }
            }
        }
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n; j++) {
                if(distance[i][j] == Integer.MAX_VALUE) {
                    System.out.print("0" + " ");
                } else {
                    System.out.print(distance[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    static class Edge {
        int vertex;
        int value;
        Edge(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }
    }
}