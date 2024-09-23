import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Actividad2 {

    // Encontrar el mínimo número de comprobantes para realizar la compra
    public static List<Integer> cambioConMinComprobantes(int[] comprobantes, int cantidad) {
        // Ordena los comprobantes en orden descendente
        Arrays.sort(comprobantes);
        List<Integer> resultado = new ArrayList<>();
        
        for (int i = comprobantes.length - 1; i >= 0; i--) {
            while (cantidad >= comprobantes[i]) {
                cantidad -= comprobantes[i];
                resultado.add(comprobantes[i]);
            }
        }

        // Si la cantidad es 0, se logro hacer el cambio exacto
        if (cantidad == 0) {
            return resultado;
        } else {
            return new ArrayList<>(); // No se puede hacer el cambio exacto
        }
    }

    public static void main(String[] args) {
        // Ejemplo
        int[] comprobantes = {5, 10, 50, 100, 200};
        int cantidad = 275; // Cantidad a cambiar

        List<Integer> resultado = cambioConMinComprobantes(comprobantes, cantidad);

        if (resultado.isEmpty()) {
            System.out.println("No es posible hacer el cambio exacto.");
        } else {
            System.out.println("Comprobantes utilizados: " + resultado);
        }
    }
}
// O(m log m)