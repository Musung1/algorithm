package dataStructure.BOJ1300;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        long start = 1;
        long end = k;

        while(start < end) {
            long middle = (start + end)/2;
            int count = 0; // middle 보다 같거나 작은 수의 갯수

            for (int i = 1; i <= n; i++) {
                count += Math.min(middle/i,n);
            }
            if(k <= count) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        System.out.println(start);
    }
}