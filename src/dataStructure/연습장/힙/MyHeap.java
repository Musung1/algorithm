package dataStructure.연습장.힙;

public class MyHeap {
    // 최대 힙
    int[] array;
    int last;

    public MyHeap() {
        array = new int[1];
        last = 0;
    }
    public int size() {
        return last;
    }
    public void add(int n) {
        // 부모와 비교해서 값 비교
        if(last == array.length-1) resize();
        array[last+1] = n;
        last++;

        int parent_idx = (last-1)/2;
        int child_idx = last;
        while(child_idx > 0) {
            if(array[parent_idx] > array[child_idx]) break;
            change(parent_idx, child_idx);
            child_idx = parent_idx;
            parent_idx = (parent_idx-1)/2;
        }
    }
    public int poll() {
        int result = array[0];
        array[0] = array[last];
        last--;

        int parent_idx = 0;
        int left_child_idx = parent_idx*2 +1;
        int right_child_idx = parent_idx*2 +2;
        while(left_child_idx <= last) {
            int max_idx = 0;

            if(left_child_idx == last) max_idx = last;
            else max_idx = array[right_child_idx] > array[left_child_idx] ? right_child_idx : left_child_idx ;

            if(array[parent_idx] > array[max_idx]) break;
            change(parent_idx,max_idx);
            parent_idx = max_idx;
            left_child_idx = parent_idx*2 +1;
            right_child_idx = parent_idx*2 +2;
        }
        return result;
    }
    public int findMax() {
        return array[0];
    }
    private void change(int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    private void resize() {
        int[] changedArray = new int[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            changedArray[i] = array[i];
        }
        array = changedArray;
    }
}
