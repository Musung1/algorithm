package dataStructure.BOJ1715;
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
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            priorityQueue.add(A[i]);
        }
        int pre = 0;
        while(priorityQueue.size() != 1) {
            int first = priorityQueue.poll();
            int second = priorityQueue.poll();
            pre += first + second;
            priorityQueue.add(first + second);
        }
        System.out.println(pre);
    }
}