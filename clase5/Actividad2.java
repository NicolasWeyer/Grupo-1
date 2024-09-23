import java.util.ArrayList;
import java.util.List;

public class Actividad2 {
    private final int numVertices;
    private final int[][] matrizAdyacencia;

    // inicializar el grafo
    public Actividad2(int numVertices) {
        this.numVertices = numVertices;
        matrizAdyacencia = new int[numVertices][numVertices];
    }

    // Agregar una arista (de vértice origen a vértice destino)
    public void agregarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            matrizAdyacencia[origen][destino] = 1;
        }
    }

    // Eliminar una arista
    public void eliminarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            matrizAdyacencia[origen][destino] = 0;
        }
    }

    // Verificar si existe una arista
    public boolean existeArista(int origen, int destino) {
        return matrizAdyacencia[origen][destino] == 1;
    }

    // Listar vértices adyacentes a un vértice dado
    public List<Integer> listarAdyacentes(int vertice) {
        List<Integer> adyacentes = new ArrayList<>();
        if (vertice >= 0 && vertice < numVertices) {
            for (int i = 0; i < numVertices; i++) {
                if (matrizAdyacencia[vertice][i] == 1) {
                    adyacentes.add(i);
                }
            }
        }
        return adyacentes;
    }

    // Contar el grado de salida de un vértice (número de aristas que salen)
    public int contarGradoSalida(int vertice) {
        int gradoSalida = 0;
        if (vertice >= 0 && vertice < numVertices) {
            for (int i = 0; i < numVertices; i++) {
                if (matrizAdyacencia[vertice][i] == 1) {
                    gradoSalida++;
                }
            }
        }
        return gradoSalida;
    }

    // Contar el grado de entrada de un vértice (número de aristas que entran)
    public int contarGradoEntrada(int vertice) {
        int gradoEntrada = 0;
        if (vertice >= 0 && vertice < numVertices) {
            for (int i = 0; i < numVertices; i++) {
                if (matrizAdyacencia[i][vertice] == 1) {
                    gradoEntrada++;
                }
            }
        }
        return gradoEntrada;
    }

    // imprimir la matriz de adyacencia
    public void imprimirMatriz() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matrizAdyacencia[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Actividad2 grafo = new Actividad2(5);  

        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(2, 4);

        System.out.println("Matriz de Adyacencia:");
        grafo.imprimirMatriz();

        System.out.println("Adyacentes del vértice 0: " + grafo.listarAdyacentes(0));

        System.out.println("Grado de salida del vértice 0: " + grafo.contarGradoSalida(0));
        System.out.println("Grado de entrada del vértice 3: " + grafo.contarGradoEntrada(3));
    }
}
