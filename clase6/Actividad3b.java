import java.util.Arrays;

public class Actividad3b {
    static class Proyecto {
        int costo;
        int beneficio;
        double ratio;

        Proyecto(int costo, int beneficio) {
            this.costo = costo;
            this.beneficio = beneficio;
            this.ratio = (double) beneficio / costo;
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

        double beneficioMaximo = calcularBeneficioMaximo(proyectos, presupuesto);
        System.out.println("Beneficio máximo (Greedy): " + beneficioMaximo);
    }

    static double calcularBeneficioMaximo(Proyecto[] proyectos, int presupuesto) {
        Arrays.sort(proyectos, (a, b) -> Double.compare(b.ratio, a.ratio));

        double beneficioTotal = 0;
        for (Proyecto p : proyectos) {
            if (presupuesto >= p.costo) {
                presupuesto -= p.costo;
                beneficioTotal += p.beneficio;
            }
        }
        return beneficioTotal;
    }
}
//O(nlogn)
