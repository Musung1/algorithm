package dataStructure.BOJ2775;
import java.io.*;
import java.nio.Buffer;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] D = new int[15][15];
        // D[a][b] = D[a-1][1] + ... D[a-1][b]
        // D[0][i] = i
        for (int i = 0; i < 15; i++) {
            D[0][i] = i;
        }
        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                for (int k = 1; k <= j; k++) {
                    D[i][j] += D[i-1][k];
                }
                //System.out.println(D[i-1][j]);
            }
        }
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());
            System.out.println(D[a][b]);
        }

    }

}