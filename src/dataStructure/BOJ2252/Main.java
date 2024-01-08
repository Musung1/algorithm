package dataStructure.BOJ2252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static ArrayList<Integer>[] graph;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        arr = new int[n+1];
        for (int i = 1; i <= n ; i++) {
            graph[i] = new ArrayList<>();
            arr[i] = 0;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            arr[b]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if(arr[i] == 0) {
                queue.add(i);
            }
        }
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.print(cur + " ");
            for(int i : graph[cur]) {
                if(--arr[i] == 0) {
                    queue.add(i);
                };
            }
        }
    }
}

