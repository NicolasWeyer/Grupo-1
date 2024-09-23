public class Actividad2b {
    static class Objeto {
        int peso;
        int valor;

        Objeto(int peso, int valor) {
            this.peso = peso;
            this.valor = valor;
        }
    }

    public static void main(String[] args) {
        Objeto[] objetos = {
            new Objeto(2, 4), // Objeto 1
            new Objeto(5, 2), // Objeto 2
            new Objeto(6, 1), // Objeto 3
            new Objeto(7, 6)  // Objeto 4
        };
        int capacidad = 10;

        int valorMaximo = mochila(objetos, capacidad);
        System.out.println("Valor máximo: " + valorMaximo);
    }

    static int mochila(Objeto[] objetos, int capacidad) {
        int n = objetos.length;
        int[][] dp = new int[n + 1][capacidad + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= capacidad; j++) {
                if (objetos[i - 1].peso <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j],
                                        dp[i - 1][j - objetos[i - 1].peso] + objetos[i - 1].valor);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][capacidad];
    }
}
