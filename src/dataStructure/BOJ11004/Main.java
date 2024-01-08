package dataStructure.BOJ11004;
import java.io.*;
import java.util.*;

public class Main {
    // 새로우 노드 빼기
    // 라스트 노드 넣기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int array[] = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < num; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        //quickSortV2(array,0,num-1);
        int[] mergedArray = mergeSort(array);
        System.out.println(mergedArray);
    }
    public static void quickSort(int[] array,int first, int last) {
        int start = first;
        int end = last -1;
        int pivot = last;
        if(start >= last) return;
        while(start < end) {
            if(array[start] < array[pivot]) start++;
            if(array[end] > array[pivot]) end--;
            if(array[start] > array[pivot] && array[end] < array[pivot]) {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
                start ++;
                end --;
            }
        }
        if (start!= end && array[start] < array[pivot]) {
            int temp = array[start + 1];
            array[start + 1] = array[pivot];
            array[pivot] = temp;
            quickSort(array,first,start);
            quickSort(array,start +2,last);
        } else {
            int temp = array[start];
            array[start] = array[pivot];
            array[pivot] = temp;
            quickSort(array,first,start-1);
            quickSort(array,start +1,last);
        }
        //1. start , end 가 만날 때까지 while 문 돌리기
        //2. pivot은 마지막 요소
        //3. start가 pivot보다 작으면 한칸 전진
        //4. end가 pivot보다 크면 한칸 후진
        //5. start가 pivot보다 크고 end가 pivot보다 작으면 swap
        //6. 만나게 되면
        //7. start와 end가 서로 뒤바뀐다면 -> start와 pivot swap
        //8. start와 end가 같은 지점이라면 -> start가 pivot보다 크면 swap, 작으면, start+1과 swap
        //9. pivot 기준 앞, 뒤, 나눠서 또 호출 -> 1개 남을 때까지
    }
    private static void quickSortV2(int[] array, int first, int last) {
        if(first >= last ) return;
        int start = first;
        int end = last;
        int pivot = last;

        while(start < end) {
            while(array[start] < array[pivot]) start++;
            while(array[end] >= array[pivot]) end--;
            if(array[start] >= array[pivot] && array[end] < array[pivot]) {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
        }
        quickSortV2(array,first,start-1);
        quickSortV2(array,start+1,last);
    }
    private static int[] mergeSort(int[] array) {
        //1. 어레이를 받는다.
        //2. 어레이를 반으로 쪼갠다.
        //3. 또 쪼갠다..
        //4. 1개가 될 때까지 쪼갠다.
        //5. 1개가 되면 다시 재귀로 올라가면서 정렬 해준다.
        //6. 이 때 정렬은 각 노드들이 정렬된 상태이기 때문에 각 노드에 포인터를 사용해서 올라가는 방식으로
        if (array.length == 1) return array;
        // 1 2 3 4 5
        // 1 2 3 | 4 5
        // 1 2 | 3 | 4 | 5
        // 1 | 2 | 3 | 4 | 5
        int middle = (array.length -1) / 2;
        int[] first = mergeSort(Arrays.copyOfRange(array,0,middle));
        int[] second = mergeSort(Arrays.copyOfRange(array,middle+1,array.length-1));

        int firstPointer = 0;
        int secondPointer =0;
        int[] mergedArray = new int[array.length];

        for(int i = 0; i < array.length; i++){
            if(first[firstPointer] < second[secondPointer]) {
                mergedArray[i] = first[firstPointer];
                firstPointer ++;
            } else {
                mergedArray[i] = second[secondPointer];
                secondPointer ++ ;
            }
            if(firstPointer == first.length) {
                for (int j = i+1; j < first.length; j++) {
                    mergedArray[j] = second[secondPointer];
                    secondPointer ++ ;
                }
                break;
            }
            if(secondPointer == second.length) {
                for (int j = i+1; j < array.length; j++) {
                    mergedArray[j] = first[firstPointer];
                    firstPointer ++ ;
                }
                break;
            }
        }
        return mergedArray;
    }


}