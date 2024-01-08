package dataStructure.BOJ1916.BOJ1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Edge>[] list;
    static int[] distance;
    static boolean[] visited;
    static int vertexNum;
    static int edgeNum;
    static int start;
    static int end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        vertexNum = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        edgeNum = Integer.parseInt(st.nextToken());
        distance = new int[vertexNum+1];
        visited = new boolean[vertexNum+1];
        list  = new ArrayList[vertexNum+1];
        for (int i = 1; i <= vertexNum ; i++) {
            distance[i] = Integer.MAX_VALUE;
            list[i] = new ArrayList<>();
            visited[i] = false;
        }
        for (int i = 1; i <= edgeNum ; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(v,e));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        findMin();
        System.out.println(distance[end]);

    }
    static void findMin(){
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(start,0));
        distance[start] = 0;
        while(!queue.isEmpty()) {
            Edge cur = queue.poll();
            if(visited[cur.vertex]) continue;
            visited[cur.vertex] = true;
            for(Edge next : list[cur.vertex]) {
                if(distance[next.vertex] > distance[cur.vertex] + next.value) {
                    distance[next.vertex] = distance[cur.vertex] + next.value;
                    queue.add(new Edge(next.vertex, distance[next.vertex]));
                }
            }
        }
    }
    static class Edge implements Comparable<Edge> {
        int vertex;
        int value;
        public Edge(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            return value - o.value;
        }
    }

}