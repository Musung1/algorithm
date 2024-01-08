package dataStructure.AWinterCamp;

import java.util.HashMap;

public class MapHash {
    private String[] keyArr = new String[0];
    private Object[] valueArr = new Object[0];

    public void add(String key, Object value) {
        int keyIndex = isKeyExist(key);
        // key 존재하지 않을 때
        if(keyIndex < 0) {
            String[] tempKeyArr = keyArr.clone();
            Object[] tempValueArr = valueArr.clone();
            keyArr = new String[tempKeyArr.length+1];
            valueArr = new Object[tempKeyArr.length+1];
            for (int i = 0; i < tempKeyArr.length; i++) {
                keyArr[i] = tempKeyArr[i];
                valueArr[i] = tempValueArr[i];
            }
            keyArr[tempKeyArr.length] = key;
            valueArr[tempKeyArr.length] = value;
        } else { // key 존재할 때
            keyArr[keyIndex] = key;
            valueArr[keyIndex] = value;
        }
    }
    public Object get(String key) {
        int keyIndex = isKeyExist(key);
        // key 존재할 때
        if(keyIndex >= 0) {
            return valueArr[keyIndex];
        } else { // key 없으면 에러
            throw new RuntimeException("값이 존재하지 않습니다");
        }
    }
    public void remove(String key) {
        int keyIndex = isKeyExist(key);
        if(keyIndex >= 0) {
            String[] tempKeyArr = keyArr.clone();
            Object[] tempValueArr = valueArr.clone();
            keyArr = new String[tempKeyArr.length-1];
            valueArr = new Object[tempKeyArr.length-1];
            for (int i = 0; i < keyArr.length; i++) {
                int index = i;
                if(i >= keyIndex) index = i + 1;
                keyArr[i] = tempKeyArr[index];
                valueArr[i] = tempValueArr[index];
            }
        } else {
            throw new RuntimeException("값이 존재하지 않습니다");
        }

    }
    public String toString() {
        String result = "";
        for (int i = 0; i < keyArr.length; i++) {
            result += "{" + keyArr[i] + " : " + valueArr[i] + "}";
            if(i != keyArr.length -1) {
                result += ", ";
            }
        }
        return result;
    }

    // key 없으면 -1, 있으면 index 반환
    private int isKeyExist(String key){
        int index = -1;
        for (int i = 0; i < keyArr.length; i++) {
            if(keyArr[i].equals(key)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
