import java.util.Arrays;

public class Actividad4b {
    static class Paquete {
        int costo;
        int ganancia;
        double ratio;

        Paquete(int costo, int ganancia) {
            this.costo = costo;
            this.ganancia = ganancia;
            this.ratio = (double) ganancia / costo;
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

        double gananciaMaxima = calcularGananciaMaxima(paquetes, presupuesto);
        System.out.println("Ganancia máxima (Greedy): " + gananciaMaxima);
    }

    static double calcularGananciaMaxima(Paquete[] paquetes, int presupuesto) {
        Arrays.sort(paquetes, (a, b) -> Double.compare(b.ratio, a.ratio));

        double gananciaTotal = 0;
        for (Paquete p : paquetes) {
            if (presupuesto >= p.costo) {
                presupuesto -= p.costo;
                gananciaTotal += p.ganancia;
            }
        }
        return gananciaTotal;
    }
}
//O(nlogn)
