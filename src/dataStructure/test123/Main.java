package dataStructure.test123;

import dataStructure.test123.config.AppConfig;

public class Main {
    public static void main(String[] args) {
        AppConfig config = new AppConfig();
        Client client = config.client();
        client.run();
    }

}
