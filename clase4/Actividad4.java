import java.util.Arrays;

public class Actividad4 {

    public static int costoMinimo(int k, int[] precios) {
        // Ordenar los precios en orden descendente
        Arrays.sort(precios);
        int n = precios.length;
        int costoTotal = 0;
        
        // Para cada flor, calcular el costo basado en cuántas ha comprado cada amigo
        for (int i = 0; i < n; i++) {
            int multiplicador = i / k + 1;
            costoTotal += multiplicador * precios[n - 1 - i];
        }

        return costoTotal;
    }

    public static void main(String[] args) {
        int[] precios = {2, 5, 6}; 
        int k = 3;  // Cantidad de amigos

        int costoTotal = costoMinimo(k, precios);
        System.out.println("El costo mínimo total es: " + costoTotal);
    }
}