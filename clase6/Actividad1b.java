public class Actividad1b {
    static int[] pesos = {3, 4, 2};
    static int[] valores = {4, 5, 3};
    static int capacidad = 6;

    // Método para resolver el problema de la mochila usando programación dinámica
    public static int mochilaDinamica(int n, int capacidad) {
        // Crear la tabla para almacenar los resultados de subproblemas
        int[][] dp = new int[n + 1][capacidad + 1];

        // Llenar la tabla usando un enfoque de abajo hacia arriba
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacidad; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;  // Sin objetos o capacidad cero
                } else if (pesos[i - 1] <= w) {
                    dp[i][w] = Math.max(valores[i - 1] + dp[i - 1][w - pesos[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // El valor máximo se encuentra en dp[n][capacidad]
        return dp[n][capacidad];
    }

    public static void main(String[] args) {
        int n = valores.length;
        int maxValor = mochilaDinamica(n, capacidad);
        System.out.println("Valor máximo obtenido (Programación Dinámica): " + maxValor);
    }
}
