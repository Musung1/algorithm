package dataStructure.coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.StringTokenizer;

public class p6 {
    static int m;
    static int[] max;
    static int[] start;
    static int num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        max = new int[m];
        start = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            max[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            start[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());

        Counter counter = new Counter(m,max,start);
        for (int i = 0; i < num; i++) {
            counter.plus();
        }
        if(counter.isError){
            System.out.println(-1);
        }else {
            for (int i = 0; i < m; i++) {
                System.out.print(counter.current[i]);
            }
        }
    }
    static class Counter {
        int m;
        int[] max;
        int[] current;
        boolean isError = false;
        Counter(int m, int[] max, int[] start) {
            this.m = m;
            this.max = max;
            this.current = start;

            for (int i = 0; i < m; i++) {
                if(current[i] > max[i]) {
                    isError = true;
                }
            }
        }
        public void plus(){
            for (int i = m-1; i >=0 ; i--) {
                if(i == 0 && current[i]+1 > max[i]) {
                    isError = true;
                    break;
                }
                if((current[i] + 1) <= max[i] ) {
                    current[i]++;
                    break;
                } else {
                    current[i] = 0;
                }
            }
        }
    }
}
//1. bfs로 탐색하기
//2. 탐색한 부분 0 으로 만들기
//3. 탐색하면서 count ++ 하면서 한번 탐색에서의 count 구하기
