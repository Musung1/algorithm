package dataStructure.coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.StringTokenizer;

public class p1 {
    static int[][] A;
    static int num = 0;
    static int count = 0;
    static int n = 0;
    static ArrayList<Integer> arrayList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        A = new int[n][n];
        arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String num = br.readLine();
            char[] numList = num.toCharArray();
            for (int j = 0; j < n; j++) {
                A[i][j] = Integer.parseInt(String.valueOf(numList[j]));
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(A[i][j] == 1) {
                    BFS(i,j);
                    arrayList.add(count);
                    num++;
                }
                count = 0;
            }
        }
        // 모두 없다면!
        if (arrayList.isEmpty()) {
            arrayList.add(0);
        } else {
            System.out.println(num);
        }
        arrayList.sort(Integer::compareTo);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i));
            if(i != arrayList.size()-1) {
                System.out.print(" ");
            }
        }
    }
    static void BFS(int i, int j){
        if(A[i][j] == 1) {
            A[i][j] = 0;
            count ++;
        }
        // 좌우위아래 탐색, 0이면 x 1이면 bfs
        // 좌
        if((i-1 >= 0)) {
            if(A[i - 1][j] == 1) {
                A[i - 1][j] = 0;
                count ++;
                BFS(i-1, j);
            }
        }
        // 우
        if(i + 1 < n) {
            if(A[i + 1][j] == 1) {
                A[i + 1][j] = 0;
                count ++;
                BFS(i+1, j);
            }
        }
        // 위
        if((j-1) >= 0) {
            if(A[i][j-1] == 1) {
                A[i][j-1] = 0;
                count ++;
                BFS(i, j-1);
            }
        }
        // 아래
        if(j + 1 < n) {
            if(A[i][j+1] == 1) {
                A[i][j+1] = 0;
                count ++;
                BFS(i, j+1);
            }
        }
    }
}
//1. bfs로 탐색하기
//2. 탐색한 부분 0 으로 만들기
//3. 탐색하면서 count ++ 하면서 한번 탐색에서의 count 구하기
