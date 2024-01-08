package dataStructure.BOJ1516;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static ArrayList<Integer>[] graph;
    static int[] values;
    static int[] arr;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        values = new int[n+1];
        arr = new int[n+1];
        result = new int[n+1];
        for (int i = 1; i <= n ; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n ; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            values[i] = time;
            int second = Integer.parseInt(st.nextToken());
            while(second != -1) {
                graph[second].add(i);
                arr[i]++;
                second = Integer.parseInt(st.nextToken());
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n ; i++) {
            if(arr[i] == 0) {
                queue.add(i);
            }
        }
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            //System.out.println(cur);
            for(int next : graph[cur]) {
                if(--arr[next] == 0) {
                    queue.add(next);
                }
                result[next] = Math.max(result[next],result[cur] + values[cur]);
            }
        }
        for (int i = 1; i <= n ; i++) {
            System.out.println(result[i] + values[i]);
        }
    }
}