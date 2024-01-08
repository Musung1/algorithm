package dataStructure.BOJ18352;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int nodeNum;
    static int edgeNum;
    static int minNum;
    static int start;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static PriorityQueue<Integer> result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        nodeNum = Integer.parseInt(st.nextToken());
        edgeNum = Integer.parseInt(st.nextToken());
        minNum = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        graph = new ArrayList[nodeNum + 1];
        visited = new boolean[nodeNum + 1];
        result = new PriorityQueue<>();
        for (int i = 1; i <= nodeNum; i++) {
            graph[i] = new ArrayList<>();
            visited[i] = false;
        }
        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            graph[first].add(second);
        }

        bfs(start,minNum);
        if(result.isEmpty()) {
            System.out.println("-1");
        }
        while(!result.isEmpty()) {
            System.out.println(result.poll());
        }
        //idea
        // 1. bfs 하면서 depth를 한 칸씩 넓혀감
        // 2. depth가 2인 아이 출력
    }
    static void bfs(int first, int minNum){
        Queue<int[]> queue = new LinkedList<>();
        visited[first] = true;
        queue.add(new int[]{first,0});
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            visited[current[0]] = true;
            if(current[1] == minNum) {
                if(!result.contains(current[0])) {
                    result.add(current[0]);
                }
            }
            for(int i : graph[current[0]]) {
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(new int[]{i,current[1]+1});
                }
            }
        }
    }
}