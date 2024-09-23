public class Actividad3c {
    static class Proyecto {
        int costo;
        int beneficio;

        Proyecto(int costo, int beneficio) {
            this.costo = costo;
            this.beneficio = beneficio;
        }
    }

    public static void main(String[] args) {
        Proyecto[] proyectos = {
            new Proyecto(10, 100),
            new Proyecto(15, 200),
            new Proyecto(20, 150),
            new Proyecto(25, 300)
        };
        int presupuesto = 40;

        int beneficioMaximo = calcularBeneficioMaximo(proyectos, presupuesto);
        System.out.println("Beneficio máximo (Programación Dinámica): " + beneficioMaximo);
    }

    static int calcularBeneficioMaximo(Proyecto[] proyectos, int presupuesto) {
        int n = proyectos.length;
        int[][] dp = new int[n + 1][presupuesto + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= presupuesto; j++) {
                if (proyectos[i - 1].costo <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j],
                                        dp[i - 1][j - proyectos[i - 1].costo] + proyectos[i - 1].beneficio);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][presupuesto];
    }
}
//O(n⋅P) donde n es el número de proyectos y P es el presupuesto
