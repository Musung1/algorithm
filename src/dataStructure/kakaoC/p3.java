package dataStructure.kakaoC;

import java.io.IOException;
import java.util.*;

public class p3 {
    static int n;
    static ArrayList<Node> comb;
    static int max = 0;
    static Node maxNode;
    static int[][] dice1;
    public static void main(String[] args) throws IOException {
        dice1 = new int[][] {{1, 2, 3, 4, 5, 6}, {3, 3, 3, 3, 4, 4}, {1, 3, 3, 4, 4, 4}, {1, 1, 4, 4, 5, 5}};
        n = dice1.length;
        comb = new ArrayList<Node>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }
        boolean[] visited = new boolean[n];
        combination(arr,visited,0,n,n/2);
        comb.get(0).DFS(0,0);
        for(Node i : comb) {
            System.out.println(i.cur);
            if(i.result > max) {
                max = i.result;
                maxNode = i;
            }
        }
        System.out.print("[");
        for (int i = 0; i < maxNode.com.length; i++) {
            System.out.print(maxNode.com[i]);
            if( i != maxNode.com.length-1) {
                System.out.print(",");
            }
        }
        System.out.println("]");


    }
    static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            int[] result = save(arr,visited,n);
            comb.add(new Node(result));
            return;
        }

        for(int i=start; i<n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }
    static int[] save(int[] arr, boolean[] visited, int n) {
        int[] result = new int[n/2];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                result[count] = arr[i];
                count++;
            }
        }
        return result;
    }
    static class Node {
        int[] com;
        int result = 0;
        int cur = 0;
        static int all = 0;
        public Node(int[] com) {
            this.com = com;
        }
        void DFS(int start, int index){
            if(start != 0) {
                for (int i = 0; i < comb.size(); i++) {
                    for (int j = 0; j < comb.get(i).com.length; j++) {
                        if(comb.get(i).com[j] == start) {
                            comb.get(i).cur += dice1[start-1][index];
                        }
                    }
                }
                all += dice1[start-1][index];
                if(start == com.length*2) {
                    for (int i = 0; i < comb.size(); i++) {
                        if (comb.get(i).cur > all/2) {
                            comb.get(i).result ++;
                        }
                    }
                    return;
                }
            }
            for (int i = 0; i < 6; i++) {
                //현재, 전체
                DFS(start + 1, i);
            }
        }

    }
}

