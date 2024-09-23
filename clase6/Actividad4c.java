public class Actividad4c {
    static class Paquete {
        int costo;
        int ganancia;

        Paquete(int costo, int ganancia) {
            this.costo = costo;
            this.ganancia = ganancia;
        }
    }

    public static void main(String[] args) {
        Paquete[] paquetes = {
            new Paquete(12, 150),
            new Paquete(20, 200),
            new Paquete(15, 100),
            new Paquete(25, 300)
        };
        int presupuesto = 35;

        int gananciaMaxima = calcularGananciaMaxima(paquetes, presupuesto);
        System.out.println("Ganancia máxima (Programación Dinámica): " + gananciaMaxima);
    }

    static int calcularGananciaMaxima(Paquete[] paquetes, int presupuesto) {
        int n = paquetes.length;
        int[][] dp = new int[n + 1][presupuesto + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= presupuesto; j++) {
                if (paquetes[i - 1].costo <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j],
                                        dp[i - 1][j - paquetes[i - 1].costo] + paquetes[i - 1].ganancia);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][presupuesto];
    }
}
//O(n*P)
