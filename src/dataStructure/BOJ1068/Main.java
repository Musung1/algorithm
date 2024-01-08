package dataStructure.BOJ1068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int removeNum;
    static int[] arr;
    static boolean[] visited;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        removeNum = Integer.parseInt(br.readLine());
        DFS(0);
        System.out.println(count);
    }
    static void DFS(int num) {
        visited[num] = true;
        for (int i = 1; i <= 2; i++) {
            int child = num*2 + i;
            if(i == 1 && child > n-1) {
                count ++;
            } else if (child < n) {
                if(!visited[child] && child != removeNum) {
                    DFS(child);
                }
            }
        }
    }
}
// 0 -> 1,2
// 1 -> 3,4
// 2 -> 5,6
// 3 -> 7,8
// 4 -> 9,10