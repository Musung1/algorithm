package dataStructure.BOJ1043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int p;
    static int trueNum;
    static int[] allMan;
    static int[] trueMan;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        n = Integer.parseInt(st.nextToken());
        allMan = new int[n + 1];
        p = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        trueNum = Integer.parseInt(st.nextToken());
        trueMan = new int[trueNum + 1];
        for (int i = 1; i <= n; i++) {
            allMan[i] = i;
        }
        for (int i = 0; i < trueNum; i++) {
            trueMan[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < trueNum; i++) {
            union(trueMan[0],trueMan[i]);
        }
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            queue.add(first);
            for (int j = 1; j < num; j++) {
                int cur = Integer.parseInt(st.nextToken());
                union(first,cur);
            }
        }
        int count = 0;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            // cur과 진실된 사람의 대표 노드가 다르면 ++;
            int rep = 0;
            if(trueMan.length > 0) {
                rep = find(trueMan[0]);
            }
            if(rep != find(cur)) {
                count++;
            }
        }
        System.out.println(count);

        // 진실을 아는 사람 모임 묶음
        // 진실을 아는 사람이 있는 모임에는 진실을 말해야 해! -> 그 모임 전부 진실을 아는 모임으로 묶음
        // 모임을 돌면서 , 진실을 아는 사람 있으면! 모두 진실의 대표 노드로 이동
        // 대표 노드가 진실을 아는 사람의 대표 노드가 아니면! -> 그 사람이 있는 모임에는 과장된 표현을 해도 됨
    }
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a > b) {
            allMan[a] = b;
        } else {
            allMan[b] = a;
        }
    }
    static int find(int a) {
        if(allMan[a] == a) {
            return a;
        }
        return allMan[a] = find(allMan[a]);
    }
}