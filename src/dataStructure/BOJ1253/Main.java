package dataStructure.BOJ1253;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(((o1, o2) -> o1 - o2));
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println(queue.poll());
        queue.stream().iterator().forEachRemaining((value)-> System.out.println(value));
    }
}