public class Actividad2 {


    final static int INF = 10000000;  // Un valor grande para representar la "infinidad"


    // Método para aplicar Floyd-Warshall (La matriz de distancia que crea este metodo representa a los tiempos
    // minimos que hay entre centros de distribucion, siendo cada centro un nondo, cada carretera una arista y el
    // tiempo entre centros es el peso de las aristas)

    public static void tiemposMasCortos(int[][] graph, int n) {
        // Matriz de distancias inicializada con los tiempos de viaje de las carreteras
        int[][] dist = new int[n][n];

        // Inicializamos la matriz de distancias con el grafo original
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Aplicamos Floyd-Warshall
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // Verificamos si el tiempo por un nodo intermedio `k` es más corto
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Verificación de ciclos negativos
        boolean neg = false;
        for (int i = 0; i < n; i++) {
            if (dist[i][i] < 0) {
                System.out.println("Ciclo negativo detectado en el centro de distribución " + i);
                neg = true;
            }
        }
        if (neg)
            return;

        // Imprimimos la matriz de distancias mínimas
        ImprimrirGrafo(dist, n);
    }

    // Método para imprimir la matriz de distancias mínimas
    public static void ImprimrirGrafo(int[][] dist, int n) {
        System.out.println("Tiempo mínimo entre cada par de centros de distribución:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Ejemplo de matriz de tiempos de viaje entre centros de distribución
        int[][] graph = {
                {0, 3, INF, INF},
                {INF, 0, 1, INF},
                {INF, INF, 0, 7},
                {2, INF, INF, 0}
        };

        int n = graph.length;

        // Llamamos al algoritmo para obtener la matriz con los tiempos mas cortos entre centros de distribucion
        tiemposMasCortos(graph, n);
    }
}