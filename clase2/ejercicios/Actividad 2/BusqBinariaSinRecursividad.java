public class BusquedaBinaria {

    public static int busquedaBinaria(int[] arreglo, int objetivo) {
        int izquierda = 0;
        int derecha = arreglo.length - 1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            if (arreglo[medio] == objetivo) {
                return medio; // Retorna el índice del objetivo
            }
            if (arreglo[medio] < objetivo) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }
        return -1;
    }

// Utilizando el siguiente main con el arreglo: {22, 31, 5, 47, 19, 11, 100}
    public static void main(String[] args) {

        int[] arreglo = {22, 31, 5, 47, 19, 11, 100};
        int objetivo = 19;
        int resultado = busquedaBinaria(arreglo, objetivo);

        if (resultado == -1) {
            System.out.println("Elemento no encontrado en el arreglo.");
        } else {
            System.out.println("Elemento encontrado en el índice: " + resultado);
        }
    }
// Si el numero que busco es el 19 el resultado por consola es: Elemento encontrado en el indice: 4

// Si el numero que busco es el 10 el resultado por consola es: Elemento no encontrado en el arreglo

}