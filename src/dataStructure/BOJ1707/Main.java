package dataStructure.BOJ1707;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeNum = Integer.parseInt(st.nextToken());
            int edgeNum = Integer.parseInt(st.nextToken());
            graph = new ArrayList[nodeNum + 1];
            visited = new int[nodeNum + 1];
            for (int j = 1; j <= nodeNum; j++) {
                graph[j] = new ArrayList<>();
                visited[i] = 0;
            }
            for (int j = 0; j < edgeNum; j++) {
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                graph[first].add(second);
                graph[second].add(first);
            }
            boolean isDone = false;
            for (int j = 1; j <= nodeNum ; j++) {
                if(visited[j] == 0) {
                    if(BFS(j) < 0) {
                        System.out.println("NO");
                        isDone = true;
                        break;
                    }
                }
            }
            if(!isDone) {
                System.out.println("YES");
            }
        }
    }
    static int BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = 1;
        queue.add(start);
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int next : graph[cur]) {
                if(visited[next] == visited[cur]) {
                    return -1;
                }
                if(visited[next] == 0) {
                    visited[next] = (visited[cur] == 1) ? 2 : 1;
                    queue.add(next);
                }
            }
        }
        return 1;
    }
}