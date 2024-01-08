package dataStructure.coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
//5 -2
//        강미나 김도연 김세정 김소혜 김청하
//        유연정 임나영 전소미 정채연 주결경
//        최유정 강시라 기희현 김나영 김소희
//        박소연 윤채경 이해인 전소연 정은우
//        한혜리 강예빈 권은빈 김다니 김서경
public class p7 {

    static int n = 0;
    static int m = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ArrayList<Cell> cells = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                cells.add(new Cell(i,j,st.nextToken()));
            }
        }
        for (Cell cell : cells) {
            cell.move(m);
        }
        Collections.sort(cells);
        int c = 0;
        for(Cell cell : cells) {
            if(cell.x >  c) {
                c = cell.x;
                System.out.println();
            }
            System.out.print(cell.name);
            System.out.print(cell.x);
            System.out.print(cell.y);
            System.out.print(cell.depth);
        }
    }
    static class Cell implements Comparable<Cell> {
        int x;
        int y;
        String name;
        int depth;
        public Cell(int x, int y,String name) {
            this.x = x;
            this.y = y;
            this.name = name;

            for (int i = 0; i < (n+1)/2; i++) {
                if(x == i || y == i || x == n-i-1 || y == n-i-1) {
                    this.depth = i;
                    break;
                }
            }
        }
        void move(int n){
            boolean k;
            if(n > 0) {
                k = true;
            } else {
                k = false;
            }
            if(depth%2 == 0 && k) {
                for (int i = 0; i < Math.abs(n); i++) {
                    if(isIn(up())) {
                        x = up()[0];
                        y = up()[1];
                        continue;
                    }
                    if(isIn(right())) {
                        x = right()[0];
                        y = right()[1];
                        continue;
                    }
                    if(isIn(down())) {
                        x = down()[0];
                        y = down()[1];
                        continue;
                    }
                    if(isIn(left())) {
                        x = left()[0];
                        y = left()[1];
                        continue;
                    }
                }
            } else {
                for (int i = 0; i < Math.abs(n); i++) {
                    if(isIn(down())) {
                        x = down()[0];
                        y = down()[1];
                        continue;
                    }
                    if(isIn(left())) {
                        x = left()[0];
                        y = left()[1];
                        continue;
                    }
                    if(isIn(up())) {
                        x = up()[0];
                        y = up()[1];
                        continue;
                    }
                    if(isIn(right())) {
                        x = right()[0];
                        y = right()[1];
                        continue;
                    }
                }
            }
        }
        int[] up(){
            int[] result = new int[2];
            result[0] = x;
            result[1] = y-1;
            return result;
        }
        int[] down(){
            int[] result = new int[2];
            result[0] = x;
            result[1] = y+1;
            return result;
        }
        int[]  right(){
            int[] result = new int[2];
            result[0] = x+1;
            result[1] = y;
            return result;
        }
        int[]  left(){
            int[] result = new int[2];
            result[0] = x-1;
            result[1] = y;
            return result;
        }
        boolean isIn(int[] location){
            if(location[0] >= depth && location[0] < (n - depth)) {
                if(location[1] >= depth && location[1] < (n - depth)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public int compareTo(Cell o) {
//            if(o.y == y) {
//                return o.x - x;
//            }
            return x - o.x;
        }
    }
}

// 바깥은 정방향
// 안쪽은 역방향
// 0 0 0 0
// 0 0 0 0
// 0 0 0 0
// 0 0 0 0
//시계방향 이동 시! i = 0 , i = max, j = 0 , j = max 인 녀석들
// 1. i 가 0 이면 j ++ , j 가 max? i--;
// 2. i = max -> i ++ , i가 max? j --;
