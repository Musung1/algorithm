package dataStructure.BOJ1717;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        A = new int[n+1];
        for (int i = 0; i <= n ; i++) {
            A[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int third = Integer.parseInt(st.nextToken());
            if(first == 0) {
                union(second,third);
            } else {
                if(find(second) == find(third)) {
                    System.out.println("YES");
                } else{
                    System.out.println("NO");
                }
            }
        }
    }
    //union , find 연산을 해준다.
    static void union(int a, int b) { // 두 개의 대표 노드를 합해준다
        int findA = find(a);
        int findB = find(b);
        if(findA > findB) {
            A[findA] = findB;
        } else {
            A[findB] = findA;
        }
//        if(findA != findB) {
//            A[b] = findA;
//        }

    }
    static int find(int a) { // 대표 노드를 찾아준다! //
        if(A[a] == a) {
            return a;
        }
        return A[a] = find(A[a]);
    }
}