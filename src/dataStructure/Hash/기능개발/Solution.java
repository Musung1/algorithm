package dataStructure.Hash.기능개발;

import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Stack<Element> stack = new Stack<>();
        for(int i = progresses.length-1; i >= 0; i--) {
            stack.push(new Element(progresses[i],speeds[i]));
        }
        ArrayList<Integer> arr = new ArrayList<>();
        int count = 1;
        while(!stack.isEmpty()) {
            int num = 0;
            int max = stack.size();
            for(int i = 0; i < max; i++) {
                Element cur = stack.peek();
                if(cur.progress + count*cur.speed < 100) {
                    break;
                }
                stack.pop();
                num++;
            }
            if(num > 0) {
                arr.add(num);
            }
            count++;
        }
        int[] answer = arr.stream().mapToInt(i->i).toArray();
        return answer;
    }
    class Element {
        int progress;
        int speed;
        public Element(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }
    }
}