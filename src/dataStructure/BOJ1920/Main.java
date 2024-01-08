package dataStructure.BOJ1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] A = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] find = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            find[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        for(int i : find) {
            binarySearchV2(A,i,0,n-1);
        }
    }
    public static void binarySearchV2(int[] A, int item, int start, int end){
        while(true) {
            int middle = (start + end)/2;
            if(item == A[middle]) {
                System.out.println(1);
                return;
            }
            if(start > end) {
                System.out.println(0);
                return;
            }
            if(item < A[middle]) {
                end = middle - 1;
            }
            if(item > A[middle]) {
                start = middle + 1;
            }
        }
    }
    public static void binarySearch(int[] A, int item, int start, int end) {
        int middle = (start + end)/2;
        if(item == A[(start + end)/2]) {
            System.out.println(1);
            return;
        }
        if(start == end) {
            System.out.println(0);
            return ;
        }
        if(item < A[middle]) binarySearch(A,item,start,middle-1);
        if(item > A[middle]) binarySearch(A,item,middle+1, end);

        // 오름차순 정렬된 리스트를 받는다.
        // 중간값이 원하는 값과 같으면 리턴
        // 중간값이 원하는 값보다 크면 0 - 중간값 -1 에서 binarySearch
        // 중간값이 원하는 값보다 작으면 중간값 +1 에서 binarySerach
        // start,end 같아지면 return false;

    }
}