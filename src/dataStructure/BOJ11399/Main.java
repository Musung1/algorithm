package dataStructure.BOJ11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int array[] = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < num; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        //insertion sort
        for(int i = 1; i < num; i++) {
            int index = i;
            for (int j = 0; j < i; j++) {
                if(array[j] > array[i]) {
                    index = j;
                    break;
                }
            }
            int tmp = array[i];
            for (int j = i; j > index; j--) {
                array[j] = array[j-1];
            }
            array[index] = tmp;
        }
        Arrays.stream(array).forEach((value -> System.out.println(value)));
        //
    }
}