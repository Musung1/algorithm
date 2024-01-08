package dataStructure.BOJ1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            Node node = new Node(start,second);
            nodes[i] = node;
        }
        Arrays.sort(nodes, new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.end == o2.end) {
                    return o1.start -o2.start;
                }
                return o1.end - o2.end;
            }
        });
        int cur = 0;
        int count = 0;
        for(Node node : nodes) {
            if(cur > node.start) {
                continue;
            }
            count++;
            cur = node.end;
        }
        System.out.println(count);
    }
    static class Node {
        int start;
        int end;
        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}