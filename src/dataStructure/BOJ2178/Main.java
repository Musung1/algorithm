package dataStructure.BOJ2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] maze;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maze = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 1; j <=m ; j++) {
                maze[i][j] = Integer.parseInt(line.substring(j-1,j));
            }
        }
        findDest();
    }
    public static void findDest() {
        node root = new node(1,1,1);
        Queue<node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            node cur = queue.poll();
            cur.visit();
            if(cur.isArrived()) {
                System.out.println(cur.depth);
                return;
            }
            if(!cur.left().isVisited()) {
                queue.add(cur.left());
                cur.left().visit();
            }
            if(!cur.right().isVisited()) {
                queue.add(cur.right());
                cur.right().visit();
            }
            if(!cur.up().isVisited()) {
                queue.add(cur.up());
                cur.up().visit();
            }
            if(!cur.down().isVisited()) {
                queue.add(cur.down());
                cur.down().visit();
            }
        }

    }
    public static class node {
        int x;
        int y;
        int depth;
        public node(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
        public node right() {
            return new node(x + 1, y,depth+1);
        }
        public node left() {
            return new node(x - 1, y,depth+1);
        }
        public node up() {
            return new node(x , y + 1,depth+1);
        }
        public node down() {
            return new node(x , y - 1,depth+1);
        }
        public void visit(){
            maze[x][y] = 0;
        }
        public boolean isVisited() {
            //1. 경로가 아니야! 0 < x < n
            if(x < 1 || x > n || y < 1 || y > m) return true;
            //2. 이미 지나간 길
            if(maze[x][y] != 1) return true;
            return false;
        }
        public boolean isArrived() {
            if(x == n && y == m) return true;
            return false;
        }
    }
}
