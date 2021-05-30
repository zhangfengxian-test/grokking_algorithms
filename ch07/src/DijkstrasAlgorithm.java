import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DijkstrasAlgorithm {

    private static Map<String, Map<String, Double>> graph = new HashMap<>();
    private static Set<String> processed = new HashSet<>();

    private static String findLowestCostNode(Map<String, Double> costs) {
        Double lowestCost = Double.POSITIVE_INFINITY;
        String lowestCostNode = null;
        for (Map.Entry<String, Double> node : costs.entrySet()) {
            Double cost = node.getValue();
            if (cost < lowestCost && !processed.contains(node.getKey())) {
                lowestCost = cost;
                lowestCostNode = node.getKey();
            }
        }
        return  lowestCostNode;
    }

    private static Map<String, Double> initCosts() {
        Map<String, Double> costs = new HashMap<>();
        costs.putAll(graph.get("start"));
        costs.put("fin", Double.POSITIVE_INFINITY);
        return costs;
    }

    private static Map<String, String> initParents() {
        Map<String, String> parents = new HashMap<>();
        for (String c : graph.get("start").keySet()) {
            parents.put(c, "start");
        }
        parents.put("fin", null);
        return parents;
    }

    private static void initGraph() {
        graph.put("start", new HashMap<>());
        graph.get("start").put("a", 6.0);
        graph.get("start").put("b", 2.0);

        graph.put("a", new HashMap<>());
        graph.get("a").put("fin", 1.0);

        graph.put("b", new HashMap<>());
        graph.get("b").put("a", 3.0);
        graph.get("b").put("fin", 5.0);

        graph.put("fin", new HashMap<>());
    }

    public static void main(String[] args) {
        initGraph();

        // The costs table
        Map<String, Double> costs = initCosts();

        // the parents table
        Map<String, String> parents = initParents();

        String node = findLowestCostNode(costs);
        while (node != null) {
            Double cost = costs.get(node);
            Map<String, Double> neighbors = graph.get(node);
            for (String n : neighbors.keySet()) {
                Double newCost = cost + neighbors.get(n);
                if (costs.get(n) > newCost) {
                    costs.put(n, newCost);
                    parents.put(n, node);
                }
            }
            processed.add(node);
            node = findLowestCostNode(costs);
        }

        System.out.println("Cost from the start to each node:");
        System.out.println(costs); // { a: 5, b: 2, fin: 6 }
    }

}
