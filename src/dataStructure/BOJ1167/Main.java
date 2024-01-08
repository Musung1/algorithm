package dataStructure.BOJ1167;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int num;
    static ArrayList<Edge>[] edges;
    static boolean[] visited;
    static int[] destValue;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = Integer.parseInt(st.nextToken());
        edges = new ArrayList[num+1];
        visited = new boolean[num+1];
        destValue = new int[num+1];
        result = new int[num+1];

        for (int i = 1; i < num+1; i++) {
            edges[i] = new ArrayList<>();
            visited[i] = false;
            destValue[i] = 0;
            result[i] = 0;
        }

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            while(true) {
                int first = Integer.parseInt(st.nextToken());
                if(first == -1) break;
                int second = Integer.parseInt(st.nextToken());
                edges[num].add(new Edge(first,second));
            }
        }
        int max = findDiameter(1);
        for (int j = 1; j < num+1; j++) {
            visited[j] = false;
            destValue[j] = 0;
        }
        max = findDiameter(max);
        System.out.println(destValue[max]);
    }
    static int findDiameter(int n) {
        Queue<Edge> queue = new LinkedList<>();
        visited[n] = true;
        for(Edge edge : edges[n]) {
            queue.add(edge);
        }
        while(!queue.isEmpty()) {
            Edge curEdge = queue.poll();
            destValue[curEdge.dest] = curEdge.value;
            visited[curEdge.dest] = true;
            for(Edge edge : edges[curEdge.dest]) {
                if(!visited[edge.dest]) {
                    visited[edge.dest] = true;
                    queue.add(new Edge(edge.dest, curEdge.value + edge.value));
                }
            }
        }
        int max = 1;
        for (int i = 1; i <=num ; i++) {
            if(destValue[max] < destValue[i]) {
                max = i;
            }
        }
        return max;
    }
    static class Edge {
        int dest;
        int value;
        public Edge(int dest, int value) {
            this.dest = dest;
            this.value = value;
        }
    }
}