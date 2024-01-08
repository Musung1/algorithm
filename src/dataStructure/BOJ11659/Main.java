package dataStructure.BOJ11659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int dataNum = Integer.parseInt(st.nextToken());
        int questionNum = Integer.parseInt(st.nextToken());
        int[] nums = new int[dataNum + 1];
        int[] S = new int[dataNum + 1];
        S[0] = 0;
        st = new StringTokenizer(br.readLine());
        //배열 받기
        for(int i = 1; i <= dataNum; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        //구간 합 구하기
        for(int i = 1; i <= dataNum; i++){
            if(i == 1){
                S[i] = nums[i];
            }
            else{
                S[i] += S[i-1] + nums[i];
            }
        }

        for(int i = 1; i <= questionNum; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            System.out.println(S[second] - S[first - 1]);
        }

    }
}