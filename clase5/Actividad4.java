import java.util.ArrayList;
import java.util.List;

class Grafo {
    private final int V; // Número de vértices
    private final List<List<Arista>> adyacente; // Lista de adyacencia

    public Grafo(int v) {
        this.V = v;
        adyacente = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adyacente.add(new ArrayList<>());
        }
    }

    // Agregar una arista al grafo
    public void agregarArista(int origen, int destino, int tiempo) {
        adyacente.get(origen).add(new Arista(destino, tiempo));
        adyacente.get(destino).add(new Arista(origen, tiempo)); 
    }

    public List<List<Arista>> getAdyacente() {
        return adyacente;
    }

    public int getV() {
        return V;
    }
}

//representar una arista
class Arista {
    int destino;
    int tiempo;

    Arista(int dest, int tiempo) {
        this.destino = dest;
        this.tiempo = tiempo;
    }
}

class AlgoritmoDijkstra {
    public static void dijkstra(Grafo grafo, int origen) {
        int[] tiempoMinimo = new int[grafo.getV()]; // Tiempo mínimo desde el origen
        boolean[] procesado = new boolean[grafo.getV()]; // Verificación de procesamiento

        for (int i = 0; i < grafo.getV(); i++) {
            tiempoMinimo[i] = Integer.MAX_VALUE;
            procesado[i] = false;
        }

        // Tiempo desde el origen a sí mismo es 0
        tiempoMinimo[origen] = 0;

        for (int i = 0; i < grafo.getV() - 1; i++) {
            // Encontrar el vértice con el tiempo mínimo no procesado
            int u = encontrarMinimo(tiempoMinimo, procesado, grafo.getV());
            procesado[u] = true;

            // Actualizar los tiempos mínimos de los vértices adyacentes
            for (Arista arista : grafo.getAdyacente().get(u)) {
                int v = arista.destino;
                int tiempo = arista.tiempo;

                // Si el vértice no está procesado y el tiempo a través de u es menor
                if (!procesado[v] && tiempoMinimo[u] != Integer.MAX_VALUE && tiempoMinimo[u] + tiempo < tiempoMinimo[v]) {
                    tiempoMinimo[v] = tiempoMinimo[u] + tiempo;
                }
            }
        }

        // Mostrar el tiempo mínimo de entrega desde el origen a los demás centros
        System.out.println("Tiempo mínimo de entrega desde el centro principal:");
        for (int i = 0; i < grafo.getV(); i++) {
            if (tiempoMinimo[i] == Integer.MAX_VALUE) {
                System.out.println("Centro " + i + ": Inaccesible");
            } else {
                System.out.println("Centro " + i + ": " + tiempoMinimo[i] + " minutos");
            }
        }
    }

    // Método para encontrar el vértice con el tiempo mínimo no procesado
    private static int encontrarMinimo(int[] tiempoMinimo, boolean[] procesado, int V) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!procesado[v] && tiempoMinimo[v] < min) {
                min = tiempoMinimo[v];
                minIndex = v;
            }
        }
        return minIndex;
    }
}

public class Actividad4 {
    public static void main(String[] args) {
        int centros = 5; 
        Grafo grafo = new Grafo(centros);

        grafo.agregarArista(0, 1, 10);
        grafo.agregarArista(0, 2, 5);
        grafo.agregarArista(1, 2, 2);
        grafo.agregarArista(1, 3, 1);
        grafo.agregarArista(2, 1, 3);
        grafo.agregarArista(2, 3, 9);
        grafo.agregarArista(2, 4, 2);
        grafo.agregarArista(3, 4, 4);
        grafo.agregarArista(4, 3, 6);

        AlgoritmoDijkstra.dijkstra(grafo, 0);
    }
}
