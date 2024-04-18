package dataStructure.test123.db;

public class RemoteDB implements DB{
    @Override
    public void getDB() {
        System.out.println("RemoteDB");
    }
    //부모타입을 하위 객체가 대신할 수 있어야한다

}


