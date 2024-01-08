package dataStructure.BOJ1016;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean[] check = new boolean[(int)(max-min)+1];

        for (long i = 2; i*i <= max ; i++) {
            long pow = i*i;
            long start = min/pow;
            if(min%pow != 0) start ++;
            for (long j = start; j*pow <= max ; j++) {
                check[(int)((j*pow)-min)] = true;
            }
        }
    }
}