package dataStructure.BOJ1219;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int start;
    static int end;
    static int m;
    static int[] money;
    static ArrayList<Edge>[] list;
    static Long[] distance;
    static Long[] checkDistance;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        money = new int[n];
        list = new ArrayList[n];
        distance = new Long[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
            distance[i] = Long.MIN_VALUE;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(v,e*-1));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n  ; i++) {
            money[i] = Integer.parseInt(st.nextToken());
        }

        distance[start] = (long) money[start];
        for (int i = 0; i < n + 100 ; i++) {
            if(i == n-1 + 100) {
                checkDistance = distance.clone();
            }
            //1. max아닌 값 찾기
            ArrayList<Integer> aNum = new ArrayList<>();
            for (int j = 0; j < n ; j++) {
                if(distance[j] != Long.MIN_VALUE) {
                    aNum.add(j);
                }
            }
            //2. 걸러진 숫자의 모든 인접 엣지 업데이트
            for (int j : aNum) {
                for (Edge edge : list[j]) {
                    if(distance[j] == Long.MAX_VALUE) distance[edge.vertex] = Long.MAX_VALUE;
                    if(distance[edge.vertex] < edge.value + distance[j] + money[edge.vertex]) {
                        distance[edge.vertex] = edge.value + distance[j] + money[edge.vertex];
                        if(i > n-1) distance[edge.vertex] = Long.MAX_VALUE;
                    }
                }
            }
            if(i == n-1 + 100) {
                if(distance[end] == Long.MIN_VALUE) {
                    System.out.println("gg");
                    return;
                }
                if(distance[end] != Long.MAX_VALUE) {
                    System.out.println(distance[end]);
                }
                else {
                    System.out.println("Gee");
                }
            }
        }
    }
    public static class Edge {
        int vertex;
        int value;
        Edge(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }
    }
}