package dataStructure.BOJ11286;
import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num  = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> {
            int firstAbs = Math.abs(o1);
            int secondAbs = Math.abs(o2);
            //1. 절대값 작은 것 위로
            //2. 절대값 같으면 값 작은거 위로
            if(firstAbs == secondAbs) {
                return o1 > o2 ? 1 : -1;
            } else return firstAbs - secondAbs;
        }));
        for(int i = 0; i < num; i++){
            int request = Integer.parseInt(br.readLine());
            if(request == 0) {
                if(queue.isEmpty()){
                    System.out.println("0");
                } else {
                    System.out.println(queue.poll());
                }
            } else {
                queue.add(request);
            }
        }
    }
}