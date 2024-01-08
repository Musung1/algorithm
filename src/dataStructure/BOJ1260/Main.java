package dataStructure.BOJ1260;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        visited = new boolean[nodeNum+1];
        graph = new ArrayList[nodeNum+1];
        for (int i = 1; i <= nodeNum ; i++) {
            graph[i] = new ArrayList<>();
            visited[i] = false;
        }
        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            graph[first].add(second);
            graph[second].add(first);
        }
        for (int i = 1; i <= nodeNum; i++) {
            Collections.sort(graph[i]);
        }
        DFS(start);
        System.out.println();
        for (int i = 1; i <= nodeNum ; i++) {
            visited[i] = false;
        }
        BFS(start);
    }
    static void DFS(int num) {
        System.out.print(num);
        System.out.print(" ");
        visited[num] = true;
        for(int i : graph[num]) {
            if(!visited[i]) {
                visited[i] = true;
                DFS(i);
            }
        }
    }
    static void BFS(int num) {
        Deque<Integer> queue = new LinkedList<>();
        queue.add(num);
        visited[num] = true;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.print(cur);
            System.out.print(" ");
            for(int i : graph[cur]) {
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}