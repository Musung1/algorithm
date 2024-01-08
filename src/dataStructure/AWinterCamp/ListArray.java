package dataStructure.AWinterCamp;

// 추가 , 제거할 때마다 arr 새로 할당
public class ListArray {
    private int[] arr = new int[0];
    public void add(int a) {
        int[] tempArr = arr.clone();
        arr = new int[arr.length+1];
        for (int i = 0; i < tempArr.length; i++) {
            arr[i] = tempArr[i];
        }
        arr[tempArr.length] = a;
    }
    public void remove(int index) {
        if(arr.length > index && index >= 0) {
            int[] tempArr = arr.clone();
            arr = new int[arr.length-1];
            for (int i = 0; i < arr.length; i++) {
                int arr_index = i;
                if(arr_index >= index) {
                    arr_index = i+1;
                }
                arr[i] = tempArr[arr_index];
            }

        }
    }
    public void all(){
        for (int i: arr) {
            System.out.println(i);
        }
    }
}
//Integer 정수
// 1. add -> 리스트에 추가
// 2. remove(index) -> index의 값 리무브
// 3. all -> 모든 값 출력
