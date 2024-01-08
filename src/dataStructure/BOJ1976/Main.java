package dataStructure.BOJ1976;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            //System.out.println(parent[i]);
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int check = Integer.parseInt(st.nextToken());
                if(check != 0) {
//                    System.out.print("index = :" + i + ",");
//                    System.out.println(j);
                    union(i,j);
//                    System.out.print("find :" + find(i) + ",");
//                    System.out.println(find(j));

                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int checkIndex = 0;
        boolean flag = false;
        for (int i = 0; i < m; i++) {
            int index = Integer.parseInt(st.nextToken());
            int findIndex = find(index);
            if(checkIndex == 0) {
                checkIndex = findIndex;
            } else {
                if(findIndex != checkIndex) {
                    System.out.println("NO");
                    flag = true;
                    break;
                }
            }
        }
        if(!flag) {
            System.out.println("YES");
        }
    }
    static void union(int a, int b){
        a = find(a); // 1
        b = find(b); // 2
        if( a > b) {
            parent[a] = b;
        } else {
            parent[b] = a; // parent[b] = 1
        }
    }
    static int find(int a) {
        if(parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }
}