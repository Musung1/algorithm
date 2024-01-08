package dataStructure.AWinterCamp;

public class SetHash {
    private String[] arr = new String[0];

    public void add(String value) {
        if(isValueExist(value) == -1) {
            String[] tempArr = arr.clone();
            arr = new String[tempArr.length+1];
            for (int i = 0; i < tempArr.length; i++) {
                arr[i] = tempArr[i];
            }
            arr[tempArr.length] = value;
        }
    }
    public void remove(String value) {
        int valueIndex = isValueExist(value);
        if(valueIndex > 0) {
            String[] tempArr = arr.clone();
            arr = new String[tempArr.length - 1];
            for (int i = 0; i < arr.length; i++) {
                int index = i;
                if(i >= valueIndex) index = i +1;
                arr[i] = tempArr[index];
            }
        } else {
            throw new RuntimeException("값이 존재하지 않습니다");
        }
    }

    public String toString() {
        String result = "";
        result += "{";
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
            if(i != arr.length -1) {
                result += ", ";
            }
        }
        result += "}";
        return result;
    }
    private int isValueExist(String value){
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals(value)) {
                return index = i;
            }
        }
        return index;
    }

}
