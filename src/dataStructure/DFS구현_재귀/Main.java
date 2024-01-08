package dataStructure.DFS구현_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static LinkedList<Integer>[] graph;
    static Boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());
        graph = new LinkedList[nodeNum + 1];
        visited = new Boolean[nodeNum + 1];
        for (int i = 1; i <= nodeNum; i++) {
            visited[i] = false;
        }
        for (int i = 1; i <= nodeNum; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 1; i <= edgeNum; i++) {
            st = new StringTokenizer(br.readLine());
            int firstNode = Integer.parseInt(st.nextToken());
            int secondNode = Integer.parseInt(st.nextToken());
            graph[firstNode].add(secondNode);
            graph[secondNode].add(firstNode);
        }
        int count = 0;
        for (int i = 1; i <= nodeNum; i++) {
            if(!visited[i]) {
                count ++;
                visited[i] = true;
                DFS(i);
            }
        }
        System.out.println(count);
    }
    public static void DFS(int start) {
        //if(visited[start]) return;
        //visited[start] = true;
        for(int i : graph[start]) {
            if(!visited[i]) {
                visited[i] = true;
                DFS(i);
            }
        }
    }
}
