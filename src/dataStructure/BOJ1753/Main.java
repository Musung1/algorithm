package dataStructure.BOJ1753;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int v;
    static int e;
    static int start;
    static ArrayList<int[]>[] graph;
    static boolean[] visited;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        visited = new boolean[v+1];
        graph = new ArrayList[v+1];
        result = new int[v+1];
        for (int i = 1; i <= v ; i++) {
            result[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= v ; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v,e});
        }
        findMin();
        for (int i = 1; i <= v ; i++) {
            if(result[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(result[i]);
            }
        }

    }
    static void findMin() {
        Queue<Integer> queue = new LinkedList<>();
        result[start] = 0;
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int[] next : graph[cur]) {
                result[next[0]] = Integer.min(result[next[0]], result[cur] + next[1]);
            }
            int d = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int i = 1; i <= v ; i++) {
                if(!visited[i]) {
                    if(result[i] < d) {
                        minIndex = i;
                        d = result[i];
                    }
                }
            }
            if(d != Integer.MAX_VALUE) {
                visited[minIndex] = true;
                queue.add(minIndex);
            }
        }
    }
}