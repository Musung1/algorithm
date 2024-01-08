package dataStructure.BOJ11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[] visited;
    static ArrayList<Integer> tree[];
    static int answer[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        tree = new ArrayList[N+1];
        answer = new int[N+1];
        for (int i = 1; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            tree[n1].add(n2);
            tree[n2].add(n1);
        }
        DFS(1);
        for (int i = 2; i <= N ; i++) {
            System.out.println(answer[i]);
        }
    }
    static void DFS(int num){
        visited[num] = true;
        for(int i : tree[num]) {
            if(!visited[i]) {
                answer[i] = num;
                DFS(i);
            }
        }
    }
}