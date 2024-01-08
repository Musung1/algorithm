package dataStructure.AWinterCamp;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Main {
    public static void main(String[] args) throws IOException {
        Arrangement arrangement = new Arrangement();
        arrangement.sort();
        System.out.println(arrangement.toString());
        arrangement.arrange(4);
    }
}