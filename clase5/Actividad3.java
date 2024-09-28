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

    // agregar una arista al grafo
    public void agregarArista(int origen, int destino, int peso) {
        adyacente.get(origen).add(new Arista(destino, peso));
        adyacente.get(destino).add(new Arista(origen, peso)); 
    }

    public List<List<Arista>> getAdyacente() {
        return adyacente;
    }

    public int getV() {
        return V;
    }
}

// representar una arista
class Arista {
    int destino;
    int peso;

    Arista(int dest, int peso) {
        this.destino = dest;
        this.peso = peso;
    }
}

class AlgoritmoPrim {
    public static void prim(Grafo grafo) {
        int[] padre = new int[grafo.getV()]; // Array para almacenar el árbol
        int[] clave = new int[grafo.getV()]; // getV = número de vértices
        boolean[] enMST = new boolean[grafo.getV()]; 

        for (int i = 0; i < grafo.getV(); i++) { //relleno claves con infinitos
            clave[i] = Integer.MAX_VALUE;
            enMST[i] = false;    
        }

        // La primera clave es siempre 0
        clave[0] = 0;
        padre[0] = -1; // El primer nodo es la raíz

        // Implementación de una lista de adyacencia como cola de prioridad
        for (int conteo = 0; conteo < grafo.getV() - 1; conteo++) {
            // Encontrar el vértice con la clave mínima
            int u = claveMinima(clave, enMST, grafo.getV());
            enMST[u] = true;

            // Recorrer los vértices adyacentes
            for (Arista arista : grafo.getAdyacente().get(u)) {
                int v = arista.destino;
                int peso = arista.peso;

                if (!enMST[v] && peso < clave[v]) {
                    padre[v] = u; // Actualizar el padre
                    clave[v] = peso; // Actualizar el peso mínimo
                }
            }
        }

        // Mostrar el conjunto de conexiones resultante y calcular el costo total
        int costoTotal = 0;
        System.out.println("Conexiones del Árbol de Recubrimiento Mínimo:");
        for (int i = 1; i < grafo.getV(); i++) {
            System.out.println("Desde " + padre[i] + " hasta " + i + " con costo: " + clave[i]);
            costoTotal += clave[i];
        }
        System.out.println("Costo total del MST: " + costoTotal);
    }

    // Método para encontrar el vértice con la clave mínima
    private static int claveMinima(int[] clave, boolean[] enMST, int V) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!enMST[v] && clave[v] < min) {
                min = clave[v];
                minIndex = v;
            }
        }
        return minIndex;
    }
}

public class Actividad3 {
    public static void main(String[] args) {
        int estaciones = 5; 
        Grafo grafo = new Grafo(estaciones);

        grafo.agregarArista(0, 1, 2);
        grafo.agregarArista(0, 3, 6);
        grafo.agregarArista(1, 2, 3);
        grafo.agregarArista(1, 3, 8);
        grafo.agregarArista(1, 4, 5);
        grafo.agregarArista(2, 4, 7);
        grafo.agregarArista(3, 4, 9);

        AlgoritmoPrim.prim(grafo);
    }
}
