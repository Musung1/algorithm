package dataStructure.BOJ2343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] A = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            if(start < A[i]) start = A[i];
            end += A[i];
        }
        // middle 값으로 3개가 나오는지 확인 해야함
        int middle = 0;
        while(start <= end) {
            middle = (start + end) / 2;
            int cur = 0;
            int count = 0;
            for (int i = 0; i < n; i++) {
                if(cur + A[i] > middle) {
                    count ++;
                    cur = 0;
                }
                cur += A[i];
            }
             count ++;
            if(count > m) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        System.out.println(start);
    }
}
