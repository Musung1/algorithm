package dataStructure.BOJ12891;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        String dna = br.readLine();
        int result = 0;
        st = new StringTokenizer(br.readLine());
        int[] dna_cur = new int[4];
        int[] dna_con = new int[4];
        for (int i = 0; i < 4; i++) {
            dna_con[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < p; i ++){
            dna_cur[dnaToInt(dna.charAt(i))] ++;
        }
        if(isSatisfy(dna_con,dna_cur)) result++;
        int start = 0;
        int last = p -1;
        for(int i = 0; i < (s-p); i++){
            dna_cur[dnaToInt(dna.charAt(start))]--;
            start ++;
            dna_cur[dnaToInt(dna.charAt(last+1))]++;
            last++;
            if(isSatisfy(dna_con,dna_cur)) result++;
        }
        System.out.println(result);
    }
    private static Boolean isSatisfy(int[] dna_con, int[] dna_cur){
        for (int i = 0; i < 4; i++) {
            if(dna_con[i] > dna_cur[i]) return false;
        }
        return true;
    }
    private static int dnaToInt(char dna){
        if(dna == 'A') return 0;
        if(dna == 'C') return 1;
        if(dna == 'G') return 2;
        if(dna == 'T') return 3;
        return 0;
    }
}