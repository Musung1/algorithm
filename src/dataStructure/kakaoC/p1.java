package dataStructure.kakaoC;

import javax.sound.midi.Receiver;
import java.io.IOException;
import java.util.*;

public class p1 {
    static String[] friends;
    static String[] gifts;
    static ArrayList<Person> people;
    public static void main(String[] args) throws IOException {
        people = new ArrayList<>();
        friends = new String[]{"joy", "brad", "alessandro", "conan", "david"};
        gifts = new String[]{"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};
        // 사람 추가
        for(String i : friends) {
            people.add(new Person(i));
        }
        // 기프트 추가
        for(String i : gifts) {
            String[] strings = i.split("\\s");
            String giver = strings[0];
            String receiver = strings[1];
            // 기프트에 따라 사람들에게 give, receive 만들어 주기

            for (int j = 0; j < people.size(); j++) {
                boolean flag = false;
                if(people.get(j).name.equals(giver)) { // giver인 사람 찾기
                    for(Give give : people.get(j).gives) {
                        if(give.name.equals(receiver)) { // receiver 찾기
                            give.giveNum++;
                            flag = true;
                            break;
                        }
                    }
                    if(!flag) {
                        people.get(j).gives.add(new Give(receiver));
                    }
                }
                flag = false;
                if(people.get(j).name.equals(receiver)) {
                    for(Receive receive : people.get(j).receives) {
                        if(receive.name.equals(giver)) {
                            receive.receiveNum++;
                            flag = true;
                            break;
                        }
                    }
                    if(!flag) {
                        people.get(j).receives.add(new Receive(giver));
                    }
                }
            }
        }
        for(Person person : people) {
            person.setRank();
        }
        int max = 0;
        // 여기서 답
        for(Person person : people) {
            System.out.println(person.name);
            System.out.println(person.getGive());
            System.out.println(person.getReceive());
            max = Math.max(person.findNextGiftNum(),max);
        }
        System.out.println(max);
    }
    static Person findPerson(String name){
        for(Person person : people) {
            if(person.name.equals(name)) {
                return person;
            }
        }
        return people.get(0);
    }
    static class Person {
        String name;
        ArrayList<Receive> receives = new ArrayList<>();
        ArrayList<Give> gives = new ArrayList<>();
        int rank = 0;
        Person(String name) {
            this.name = name;
        }
        int findNextGiftNum(){
            int count = 0;
            // 준 선물 > 받은 선물인지 비교!
            for(Person person: people) {
                if(person.name.equals(name)) continue;
                int giveNum = 0;
                int receiveNum = 0;
                // 1. 나하고 선물 주고 받은 애 찾기
                //1. 내가 person한테 준 수
                for(Give give : gives) {
                    //System.out.println(give.name);
                    if(give.name.equals(person.name)){
                        giveNum = give.giveNum;
                        break;
                    }
                }
                //2. person이 나한테 준 수 찾기
                for(Receive receive : receives) {
                    if(receive.name.equals(person.name)) {
                        receiveNum = receive.receiveNum;
                        //System.out.println(receiveNum);
                        break;
                    }
                }
                if(giveNum > receiveNum) {
                    count++;
                } else if(giveNum == 0 && receiveNum == 0 || giveNum == receiveNum){
                    if(rank > person.rank) {
                        count++;
                    }
                }
            }
            return count;
        }
        int getGive(){
            int result = 0;
            for(Give cur : gives) {
                result += cur.giveNum;
            }
            return  result;
        }
        int getReceive(){
            int result = 0;
            for(Receive cur : receives) {
                result += cur.receiveNum;
            }
            return result;
        }
        void setRank(){
            int receive = getReceive();
            int give = getGive();
            rank =  give - receive;
        }
    }
    static class Receive {
        String name;
        int receiveNum = 1;
        Receive(String name) {
            this.name = name;
        }

    }
    static class Give {
        String name;
        int giveNum = 1;
        Give(String name) {
            this.name = name;
        }
    }
}

