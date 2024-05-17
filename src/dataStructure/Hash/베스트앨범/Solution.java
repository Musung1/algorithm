package dataStructure.Hash.베스트앨범;

import java.util.*;
class Solution {
    //장르순(많이 재생된)
    //장르내에서 재생 순
    //고유번호 같으면 낮은 고유번호 순
    // 1.map에 key:장르, value = 리스트
    // 2.map 순회하면서 장르의 순서를 정한다.
    // 3. priorityqueue 에서 재생순 ,
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String,PriorityQueue<Element>> hm = new HashMap();
        for(int i = 0; i < genres.length; i++) {
            String key = genres[i];
            if(!hm.containsKey(key)) {
                hm.put(key,new PriorityQueue<Element>((o1,o2)->{
                    if(o1.value - o2.value == 0) {
                        return o1.index - o2.index;
                    }
                    return o2.value - o1.value;
                }));
            }
            hm.get(key).add(new Element(i,plays[i]));
        }
        List<String> li = new ArrayList();
        PriorityQueue<Genres> pq = new PriorityQueue<>((o1, o2) -> o2.value - o1.value);
        for(String key: hm.keySet()) {
            PriorityQueue<Element> hmPq = hm.get(key);
            Iterator<Element> iter = hmPq.iterator();
            int sum = 0;
            while(iter.hasNext()) {
                sum += iter.next().value;
            }
            pq.add(new Genres(key,sum));
        }
        int[] answer = {};
        return answer;
    }
    class Element {
        int index;
        int value;
        public Element(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
    class Genres {
        String key;
        int value;
        public Genres(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}