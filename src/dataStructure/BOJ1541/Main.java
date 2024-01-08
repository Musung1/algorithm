package dataStructure.BOJ1541;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        //-명 묶기,
        // 연산자 나오기 전까지는 숫자
        // 연산자 나오면 연산!

        int pre = -1;
        boolean isMinus = false;
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            int num = 0;
            if(input.charAt(i) == '+') {
                num = Integer.parseInt(input.substring(pre+1,i));
                if(isMinus) {
                    count -= num;
                } else {
                    count += num;
                }
                pre = i;
            } else if (input.charAt(i) == '-') {
                num = Integer.parseInt(input.substring(pre+1,i));
                if(isMinus) {
                    count -= num;
                } else {
                    count += num;
                }
                isMinus = true;
                pre = i;
            }
        }
        if(isMinus) {
            count -= Integer.parseInt(input.substring(pre+1,input.length()));
        } else {
            count += Integer.parseInt(input.substring(pre+1,input.length()));
        }
        System.out.println(count);
    }
}