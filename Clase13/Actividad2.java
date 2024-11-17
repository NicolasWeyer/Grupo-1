import java.util.*;
public class Actividad2 {

    static class Node {
        String name;
        int cost;

        public Node(String name, int cost) {
            this.name = name;
            this.cost = cost;
        }
    }

    public static class UCS {
        private final Map<String, List<Node>> graph = new HashMap<>();

        // Agregar conexiones al grafo
        public void addEdge(String from, String to, int cost) {
            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(new Node(to, cost));
        }

        // Método para realizar la búsqueda UCS con detalle de escalas
        public List<String> uniformCostSearch(String start, String goal) {
            PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
            Map<String, Integer> costSoFar = new HashMap<>();
            Map<String, String> cameFrom = new HashMap<>();
            List<String> path = new ArrayList<>();

            priorityQueue.add(new Node(start, 0));
            costSoFar.put(start, 0);

            while (!priorityQueue.isEmpty()) {
                Node current = priorityQueue.poll();

                // Si alcanzamos el nodo objetivo, reconstruimos el camino
                if (current.name.equals(goal)) {
                    String step = goal;
                    while (step != null) {
                        path.add(0, step);
                        step = cameFrom.get(step);
                    }
                    return path;
                }

                // Explorar vecinos
                for (Node neighbor : graph.getOrDefault(current.name, new ArrayList<>())) {
                    int newCost = costSoFar.getOrDefault(current.name, Integer.MAX_VALUE) + neighbor.cost;

                    // Si encontramos un camino más barato hacia el vecino
                    if (newCost < costSoFar.getOrDefault(neighbor.name, Integer.MAX_VALUE)) {
                        costSoFar.put(neighbor.name, newCost);
                        cameFrom.put(neighbor.name, current.name);
                        priorityQueue.add(new Node(neighbor.name, newCost));
                    }
                }
            }

            return null; // Retorna null si no se encuentra un camino
        }


    }
    public static void main(String[] args) {

        UCS ucs = new UCS();

        // Agregar rutas entre destinos (conexiones)
        ucs.addEdge("Nueva York", "Londres", 500);
        ucs.addEdge("Nueva York", "París", 450);
        ucs.addEdge("Londres", "Berlín", 150);
        ucs.addEdge("París", "Berlín", 200);
        ucs.addEdge("Berlín", "Tokio", 800);
        ucs.addEdge("Londres", "Tokio", 900);

        // Definir destino inicial y final
        String origen = "Nueva York";
        String destino = "Tokio";

        // Ejecutar UCS
        List<String> ruta = ucs.uniformCostSearch(origen, destino);
        if (ruta != null) {
            System.out.println("El camino más barato desde " + origen + " hasta " + destino + " es:");
            System.out.println(String.join(" → ", ruta));
        } else {
            System.out.println("No se encontró un camino desde " + origen + " hasta " + destino);
        }
    }

}
