public class Actividad1a {
    static int[] pesos = {3, 4, 2};
    static int[] valores = {4, 5, 3};
    static int capacidad = 6;
    
    // Método para encontrar el valor máximo usando fuerza bruta
    public static int fuerzaBruta(int n, int capacidadRestante) {
        // sin objetos o sin capacidad restante
        if (n == 0 || capacidadRestante == 0) {
            return 0;
        }

        // Si el peso del objeto actual es mayor que la capacidad restante, no se puede incluir
        if (pesos[n - 1] > capacidadRestante) {
            return fuerzaBruta(n - 1, capacidadRestante);
        }

        // No incluir el objeto actual
        int noIncluir = fuerzaBruta(n - 1, capacidadRestante);

        // Incluir el objeto actual
        int incluir = valores[n - 1] + fuerzaBruta(n - 1, capacidadRestante - pesos[n - 1]);

        // Devolver el máximo entre incluir o no incluir
        return Math.max(noIncluir, incluir);
    }

    public static void main(String[] args) {
        int n = valores.length;
        int maxValor = fuerzaBruta(n, capacidad);
        System.out.println("Valor máximo obtenido (Fuerza Bruta): " + maxValor);
    }
}
