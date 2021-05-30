import java.util.HashMap;
import java.util.Map;

public class Voter {
    private static Map<String, Boolean> voted = new HashMap<>();

    static void checkVoter(String name) {
        if (voted.get(name) == Boolean.TRUE) {
            System.out.println("kick them out!");
        } else {
            voted.put(name, true);
            System.out.println("let them vote!");
        }
    }

    public static void main(String[] args) {
        checkVoter("Jake");
        checkVoter("Tom");
        checkVoter("Tom");
    }

}
