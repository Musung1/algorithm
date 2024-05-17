package dataStructure.Hash.전화번호목록;

import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        // create map
        Map<String,Integer> map = new HashMap<String,Integer>();
        // add phone_book element
        for(int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i],i);
        }
        // 맵 요소 하나식 순회하면서 
        for(int i = 0; i < phone_book.length; i++) {
            // 요소의 길이만큼 순회하면서
            for(int j = 0; j < phone_book[i].length(); j++) {
                String target = phone_book[i].substring(0,j);
                // 맵에 타겟이 있는지 확인
                if(map.containsKey(target)) {
                    return false;
                }
            }
        }
        return true;
    }
}