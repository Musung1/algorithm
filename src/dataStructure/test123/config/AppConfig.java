package dataStructure.test123.config;

import dataStructure.test123.Client;
import dataStructure.test123.db.DB;
import dataStructure.test123.db.MemoryDB;
import dataStructure.test123.db.RemoteDB;

public class AppConfig {
    public DB memoryDb() {
        return new MemoryDB();
    }
    public DB remoteDb() {
        return new RemoteDB();
    }
    public Client client() {
        return new Client(remoteDb());
    }
}
