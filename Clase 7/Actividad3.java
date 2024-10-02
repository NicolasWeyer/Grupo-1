import java.util.Scanner;

public class Actividad3 {

    //La diferencia con la actividad 2 es que en este caso utilizo una segunda matriz que me indica el camino que
    //realizo para llegar a un destino en lugar de el tiempo que tardo
    
    final static int INF = 10000000; // Un valor grande para representar "infinito"

    // Método para aplicar Floyd-Warshall y guardar predecesores
    public static void floydWarshall(int[][] graph, int[][] next, int n) {
        int[][] dist = new int[n][n];

        // Inicializar la matriz de distancias y predecesores
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = graph[i][j];
                if (graph[i][j] != INF && i != j) {
                    next[i][j] = j;  // El predecesor de j desde i es j
                } else {
                    next[i][j] = -1;  // No hay camino entre i y j
                }
            }
        }

        // Aplicar el algoritmo de Floyd-Warshall
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][i] != -INF && dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];  // Actualizar el predecesor
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

        // Pide al usuario el origen y destino para mostrar el camino más corto
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el centro de distribución de origen (0 a " + (n - 1) + "): ");
        int origen = scanner.nextInt();
        System.out.print("Ingrese el centro de distribución de destino (0 a " + (n - 1) + "): ");
        int destino = scanner.nextInt();

        // Mostrar el camino más corto entre origen y destino
        if (dist[origen][destino] == INF) {
            System.out.println("No hay camino entre el origen y el destino.");
        } else {
            System.out.println("El tiempo mínimo entre el centro " + origen + " y el centro " + destino + " es: " + dist[origen][destino]);
            System.out.print("El camino más corto es: ");
            imprimirCamino(origen, destino, next);
            System.out.println();
        }
    }

    // Función para imprimir el camino más corto utilizando la matriz de predecesores
    public static void imprimirCamino(int origen, int destino, int[][] next) {
        if (next[origen][destino] == -1) {
            System.out.println("No hay camino.");
            return;
        }
        System.out.print(origen + " ");
        while (origen != destino) {
            origen = next[origen][destino];
            System.out.print(origen + " ");
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

        // Inicializamos la matriz de predecesores
        int[][] next = new int[n][n];

        // Llamamos al algoritmo de Floyd-Warshall
        floydWarshall(graph, next, n);
    }
}