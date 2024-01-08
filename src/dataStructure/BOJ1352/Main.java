package dataStructure.BOJ1352;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int nodeNum;
    static int edgeNum;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static int max = 0;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        nodeNum = Integer.parseInt(st.nextToken());
        edgeNum = Integer.parseInt(st.nextToken());
        visited = new boolean[nodeNum + 1];
        graph = new ArrayList[nodeNum + 1];
        result = new int[nodeNum + 1];

        for (int i = 1; i <= nodeNum ; i++) {
            visited[i] = false;
            graph[i] = new ArrayList();
        }
        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            graph[second].add(first);
        }

        for (int i = 1; i <= nodeNum; i++) {
            for (int j = 1; j <= nodeNum ; j++) {
                visited[j] = false;
            }
            BFS(i);
            result[i] = max;
            max = 0;
        }

        for (int i = 1; i <= nodeNum; i++) {
            if(result[i] > max) {
                max = result[i];
            }
        }
        for (int i = 1 ; i <= nodeNum ; i++) {
            if(result[i] == max) {
                System.out.print(i);
                System.out.print(" ");
            }
        }
    }
    static void DFS(int start) {
        visited[start] = true;
        for(int i : graph[start]) {
            if(!visited[i]) {
                visited[i] = true;
                max++;
                DFS(i);
            }
        }
    }
    static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int i : graph[cur]) {
                if(!visited[i]) {
                    visited[i] = true;
                    max++;
                    queue.add(i);
                }
            }
        }
    }
}