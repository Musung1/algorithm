package dataStructure.BOJ14425;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static String[] strings;
    static String[] finds;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        strings = new String[n];
        finds = new String[m];
        tNode root = new tNode();
        for (int i = 0; i < n; i++) {
            String text = br.readLine();
            tNode now = root;
            for (int j = 0; j < text.length(); j++) {
                char c = text.charAt(j);
                if(now.next[c-'a'] == null) {
                    now.next[c-'a'] = new tNode();
                }
                now = now.next[c-'a'];
                if(j == text.length() - 1) now.isEnd = true;
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            String text = br.readLine();
            tNode now = root;
            for (int j = 0; j < text.length(); j++) {
                char c = text.charAt(j);
                if(now.next[c-'a'] == null) {
                    break;
                }
                now = now.next[c-'a'];
                if(j == text.length()-1 && now.isEnd) count++;
            }
        }
        System.out.println(count);

    }
    static class tNode {
        tNode[] next = new tNode[26];
        boolean isEnd;
    }
}