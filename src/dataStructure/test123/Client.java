package dataStructure.test123;

import dataStructure.test123.db.DB;
import dataStructure.test123.db.MemoryDB;
import dataStructure.test123.db.RemoteDB;

public class Client {
    private DB db;
    public Client(DB db) {
        this.db = db;
    }
    public void run() {
        db.getDB();
    }
}
// 2. momorydb -> remoteDB로 바꾸려면 client의 코드를 바꿔야함 (Open-Closed Principle, OCP) X
// 3. 지금 인터페이스 최대한 분리해서 작성함! Interface ISP OK
// 4. db 가져오라는 인터페이스 말 대로 함 ! 리스코프치환원칙 OK!
// 5. DIP 한마디로 (인터페이스에만! 의존해라)
// 참고로 의존한다는 말은 그냥 단순하게 작성되있다는거임

//결론 : OCP 안지켜짐, DIP 안지켜짐!
// 스프링은 순수한 자바코드로 객체지향 설계원칙(SOLID)을 쉽게 하기 위해!
