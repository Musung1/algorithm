package dataStructure.BOJ1197;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int V;
    static int E;
    static Edge[] edges;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        edges = new Edge[E];
        parent = new int[V+1];
        for (int i = 1; i <= V ; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start,end,value);
        }
        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.value - o2.value;
            }
        });
        int count = 0;
        long result = 0;
        for (int i = 0; i < E; i++) {
            Edge cur = edges[i];
            int findStart = find(cur.start);
            int findEnd = find(cur.end);
            if(findStart != findEnd) {
                union(cur.start, cur.end);
                result += cur.value;
                count++;
            }
            if(count == V-1) break;
        }
        System.out.println(result);
    }

    static void union(int o1, int o2) {
        if(o1 < o2) {
            parent[find(o2)] = parent[find(o1)];
        } else {
            parent[find(o1)] = parent[find(o2)];
        }
    }
    static int find(int o1) {
        if(parent[o1] == o1) return o1;
        return parent[o1] = find(parent[o1]);
    }
    static class Edge {
        int start;
        int end;
        int value;
        public Edge(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }
}