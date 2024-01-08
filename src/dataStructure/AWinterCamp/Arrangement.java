package dataStructure.AWinterCamp;

import java.util.Arrays;
import java.util.Comparator;

//학번 이름 성별 점수를 선언한 20명의 학생
public class Arrangement {
    String[][] students = new String[20][4];
    public Arrangement() {
        for (int i = 0; i < 20; i++) {
            students[i][0] = String.valueOf(i);
            students[i][1] = i + "이름";
            students[i][2] = (i%2 == 0)? "남성" : "여성";
            students[i][3] = String.valueOf((int) (Math.random() * 100));
        }
        System.out.println(toString());
    }
    public void sort() {
        Arrays.sort(students, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[2].equals(o2[2])) { // 성별이 같을 경우
                    return Integer.parseInt(o2[3]) - Integer.parseInt(o1[3]);
                } else if(o1[2].equals("남성")) { // 성별이 다를 경우
                    return -1 ;
                } else {
                    return 1;
                }
            }
        });
    }
    // 학생 반 지정
    public void arrange(int class_num) {
        String result = "순번 학번 이름 성별 점수 반" + "\n";
        for (int i = 0; i < 20 ; i++) {
            result += i + " " + students[i][0]+ " " + students[i][1]+ " " + students[i][2]+ " " + students[i][3];
            int num = ((i/class_num)%2 == 0) ? ((i%4 + 1)) : class_num - ((i%4));
            result +=  " " + num + "\n";
        }
        System.out.println(result);
    }
    public String toString() {
        String result = "순번 학번 이름 성별 점수" + "\n";
        for (int i = 0; i < 20 ; i++) {
            result += i + " " + students[i][0]+ " " + students[i][1]+ " " + students[i][2]+ " " + students[i][3] + "\n";
        }
        return result;
    }
}
