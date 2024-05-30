package dataStructure.Hash.올바른괄호;
import java.util.* ;
class Solution {
    static boolean[] visited;
    boolean solution(String s) {
        char[] charArr = s.toCharArray();
        visited = new boolean[charArr.length];
        for(int i = 0; i < charArr.length; i++) {
            if(!visited[i]) {
                boolean answer = match(i,charArr);
                if(!answer) return false;
            }
        }
        return true;
    }
    /// (()())()
    public boolean match(int index, char[] charArr) {
        int cur = charArr[index];
        visited[index] = true;
        if(cur == ')') return false;
        for(int i = index+1; i < charArr.length; i++) {
            if(!visited[i]) {
                int next = charArr[i];
                if(next == '(') {
                    boolean isMatch = match(i,charArr);
                    if(!isMatch) return false;
                }
                if(next == ')') {
                    visited[i] = true;
                    return true;
                }
            }
        }
        return false;
    }
}