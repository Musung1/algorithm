package dataStructure.BOJ9252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();
        int x = 0;
        int y = 0;
        int max = 0;
        dp = new int[first.length()+1][second.length()+1];
        for (int i = 1; i <= first.length(); i++) {
            for (int j = 1; j <= second.length(); j++) {
                if(first.charAt(i-1) == second.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    if(dp[i][j] > max) {
                        x = i;
                        y = j;
                        max = dp[i][j];
                    }
                } else {
                    dp[i][j] = Integer.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        max = dp[x][y];
        int count = max-1;
        char[] result = new char[max];
        Stack<Character> stack = new Stack<>();
        while(x > 0 && y > 0) {
            if(dp[x][y] == dp[x-1][y]) {
                x--;
            } else if(dp[x][y] == dp[x][y-1])  {
                y--;
            } else {
                x--;
                y--;
                stack.add(first.charAt(x));
            }
        }
//        for (int i = x; i >= 1 ; i--) {
//            for (int j = y; j >= 1 ; j--) {
//                if(first.charAt(i-1) == second.charAt(j-1)) {
//                    result[count] = first.charAt(i-1);
//                    stack.push(first.charAt(i-1));
//                    count--;
//                    y = j-1;
//                    break;
//                }
//            }
//        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
//        for (int i = 1; i <= first.length(); i++) {
//            for (int j = 1; j <= second.length(); j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

//        System.out.println(max);
//        for (int i = 0; i < max; i++) {
//            System.out.print(result[i]);
//        }
        //ToString(first.toCharArray(), first.length(), second.length());
        System.out.println(dp[first.length()][second.length()]);
        System.out.println(sb);
    }
    static void ToString(char[] str, int i, int j) {
        Stack<Character> st = new Stack<>();
        while (i > 0 && j > 0) {
            if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else if (dp[i][j] == dp[i][j - 1]) {
                j--;
            } else {
                st.push(str[i-1]);
                i--;
                j--;
            }
        }
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
    }
}
