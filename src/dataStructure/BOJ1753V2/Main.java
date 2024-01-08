package dataStructure.BOJ1753V2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int v;
    static int e;
    static int start;
    static ArrayList<Edge>[] graph;
    static boolean[] visited;
    static int[] result;
    static PriorityQueue<Edge> q = new PriorityQueue<Edge>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        visited = new boolean[v + 1];
        graph = new ArrayList[v + 1];
        result = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            result[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v,e));
        }
        q.add(new Edge(start,0));
        result[start] = 0;
        while(!q.isEmpty()) {
            Edge cur = q.poll();
            if(visited[cur.vertex]) continue;
            visited[cur.vertex] = true;
            for (int i = 0; i < graph[cur.vertex].size(); i++) {
                Edge next = graph[cur.vertex].get(i);
                if(result[next.vertex] > result[cur.vertex] + next.value) {
                    result[next.vertex] = result[cur.vertex] + next.value;
                    q.add(new Edge(next.vertex, result[next.vertex]));
                }
            }
        }
        for (int i = 1; i <= v ; i++) {
            if(visited[i]) {
                System.out.println(result[i]);
            } else {
                System.out.println("INF");
            }
        }
    }
    static class Edge implements Comparable<Edge> {
        int vertex, value;
        Edge(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            if (this.value > o.value) return 1;
            else return -1;
        }
    }
}