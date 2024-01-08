package dataStructure.AWinterCamp;
/*
2. 문자열에 숫자가 몇개인지 파악하는 프로그램 만들기
글자에 숫자 몇개인지 알려주는 메서드
이 클래스에 대해서 설명해주는 toString 메서드
NumString 이라는 클래스 만들어서 메서드 2개 만들어주세요
 */
public class NumString {
    private String inputString;
    public NumString(String inputString) {
        this.inputString = inputString;
    }
    public void count() {
        int count = 0;
        for(char i : inputString.toCharArray()) {
            if(isNumber(i)) count++;
        }
        System.out.println("숫자의 개수는 " + count + "개 입니다");
    }
    public String toString() {
        return "문자열에서 숫자의 개수를 세는 클래스입니다";
    }
    private boolean isNumber(char i){
        if(Character.isDigit(i)) {
            return true;
        }
        return false;
    }
}
