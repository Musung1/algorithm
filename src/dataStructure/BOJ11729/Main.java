package dataStructure.BOJ11729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String nums = br.readLine();
        int sum = 0;

        for(int i = 0; i<num; i++){
            sum += Integer.parseInt(nums.substring(i,i+1));
        }
        System.out.println(sum);
    }
}