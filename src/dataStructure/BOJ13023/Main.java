package dataStructure.BOJ13023;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static boolean arrive = false;
    static LinkedList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());
        graph = new LinkedList[nodeNum];
        visited = new boolean[nodeNum];

        // 초기화
        for (int i = 0; i < nodeNum; i++) {
            graph[i] = new LinkedList<>();
            visited[i] = false;
        }
        // 그래프 만들기
        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            graph[first].add(second);
            graph[second].add(first);
        }

        for (int i = 0; i < nodeNum; i++) {
            DFS(i,1);
            if(arrive) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }
    static void DFS(int num, int depth) {
        visited[num] = true;
        if (depth == 5 || arrive) {
            arrive = true;
            return;
        }
        for(int i : graph[num]) {
            if(!visited[i]) {
                DFS(i,depth+1);
            }
        }
        visited[num] = false;
    }
}