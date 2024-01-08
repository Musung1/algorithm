package dataStructure.BOJ2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        int num = Integer.parseInt(br.readLine());
        for (int i = 1; i <= num; i++) {
            queue.add(i);
        }
        int result = 0;
        while(true) {
            int first = queue.poll();
            if (queue.isEmpty()) {
                result = first;
                break;
            }
            int second = queue.poll();
            queue.add(second);
        }
        System.out.println(result);
    }
}
