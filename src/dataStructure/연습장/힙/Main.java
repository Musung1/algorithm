package dataStructure.연습장.힙;
import java.util.*;
class Main {
    public static void main(String[] args) {
        MyHeap myHeap = new MyHeap();
        myHeap.add(4);
        myHeap.add(1);
        myHeap.add(9);
        myHeap.add(5);
        myHeap.add(2);
        int size = myHeap.size();
        for (int i = 0; i < size; i++) {
            System.out.println(myHeap.poll());
        }
        System.out.println(myHeap.size());
    }
}