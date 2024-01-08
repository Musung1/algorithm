package dataStructure.BOJ1744;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        long result = 0;
        Arrays.sort(A);
        long pre = 1;
        int quit = 0;
        if(n == 1) {
            System.out.println(A[0]);
            return;
        }
        for (int i = 0; i < n; i++) {
            if(A[i] <= 0) {
                if(pre == 1) {
                    pre = A[i];
                } else {
                    result += pre*A[i];
                    pre = 1;
                }
            } else {
                quit = i;
                break;
            }
        }
        if(pre != 1) {
            result += pre;
        }
        pre = 0;
        for (int i = n-1; i >= quit ; i--) {
            if(pre == 0) { // 이전이 없음
                if(A[i] == 1) { // 1이면 무적권 더함
                    result += 1;
                    pre = 0;
                } else { // 1 아니면 곱함
                    pre = A[i];
                }
            } else {
                if (A[i] == 1) {
                    result += 1;
                    result += pre;
                } else {
                    result += pre*A[i];
                }
                pre = 0;
            }
        }
        if(pre != 0) {
            result += pre;
        }
        System.out.println(result);
    }
}