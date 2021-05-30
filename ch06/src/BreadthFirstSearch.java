import java.util.*;

public class BreadthFirstSearch {

    private static final Map<String, List<String>> graph = new HashMap<>();

    static {
        graph.put("you", Arrays.asList("alice", "bob", "claire"));
        graph.put("bob", Arrays.asList("anuj", "peggy"));
        graph.put("alice", Arrays.asList("peggy"));
        graph.put("claire", Arrays.asList("thom", "jonny"));
        graph.put("anuj", Arrays.asList());
        graph.put("peggy", Arrays.asList());
        graph.put("thom", Arrays.asList());
        graph.put("jonny", Arrays.asList());
    }

    public static boolean search(String name) {
        Queue<String> searchQueue = new ArrayDeque<>();
        searchQueue.addAll(graph.get(name));
        Set<String> searched = new HashSet<>();
        while (!searchQueue.isEmpty()) {
            String person = searchQueue.poll();
            if (!searched.contains(person)) {
                if (personIsSeller(person)) {
                    System.out.println((person + " is a mango seller!"));
                    return true;
                } else {
                    searchQueue.addAll(graph.get(person));
                    searched.add(person);
                }
            }
        }
        return false;
    }

    private static boolean personIsSeller(String person) {
        return person.endsWith("m");
    }

    public static void main(String[] args) {
        search("you");
    }

}
