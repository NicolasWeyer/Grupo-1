public class Actividad4a {
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

        Resultado resultado = calcularMaximaGanancia(paquetes, presupuesto, 0, 0);
        System.out.println("Ganancia máxima (Fuerza Bruta): " + resultado.gananciaMaxima);
    }

    static class Resultado {
        int gananciaMaxima;

        Resultado(int gananciaMaxima) {
            this.gananciaMaxima = gananciaMaxima;
        }
    }

    static Resultado calcularMaximaGanancia(Paquete[] paquetes, int presupuesto, int indice, int gananciaActual) {
        if (indice >= paquetes.length) {
            return new Resultado(gananciaActual);
        }

        // No incluir el paquete actual
        Resultado sinActual = calcularMaximaGanancia(paquetes, presupuesto, indice + 1, gananciaActual);

        // Incluir el paquete actual
        Resultado conActual = new Resultado(0);
        if (paquetes[indice].costo <= presupuesto) {
            conActual = calcularMaximaGanancia(paquetes, presupuesto - paquetes[indice].costo, indice + 1,
                                                gananciaActual + paquetes[indice].ganancia);
        }

        // Devolver el mejor resultado
        return sinActual.gananciaMaxima > conActual.gananciaMaxima ? sinActual : conActual;
    }
}
//O(2^n)
