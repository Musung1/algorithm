package dataStructure.BOJ2750;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int array[] = new int[num];
        for (int i = 0; i < num; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        //bubble sort
        bubbleSort(array);
        Arrays.stream(array).forEach((value -> System.out.println(value)));
    }
    public static void bubbleSort(int[] array){
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1; j++) {
                if(array[j] >  array[j+1]) {
                    int temp = array[j] ;
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
}