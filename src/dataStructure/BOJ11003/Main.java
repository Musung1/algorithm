package dataStructure.BOJ11003;
import java.io.*;
import java.sql.Array;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    // 새로우 노드 빼기
    // 라스트 노드 넣기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        Deque<Node> deque = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N ; i++) {
            int start = i - L + 1;
            int last = i;
            Node node = new Node(i,A[i]);
//            System.out.println("L : " + L);
//            System.out.println("start : " + start);
            if(start > 0){
                if(start-1 == deque.getFirst().index) deque.removeFirst();
            }
            while(!deque.isEmpty()){
                if(deque.getLast().value > node.value) deque.removeLast();
                else break;

            }
            deque.addLast(node);
//            deque.stream().forEach((value)-> System.out.print(value.value + " "));
//            System.out.println();
            bw.write(deque.getFirst().value+ " ");
        }
        bw.flush();
        bw.close();
    }
    static class Node{
        int index;
        int value;
        Node(int index, int value){
            this.index = index;
            this.value = value;
        }
    }
}