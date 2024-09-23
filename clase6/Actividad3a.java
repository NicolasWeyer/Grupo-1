public class Actividad3a {
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

        Resultado resultado = calcularMaximoBeneficio(proyectos, presupuesto, 0, 0);
        System.out.println("Beneficio máximo (Fuerza Bruta): " + resultado.beneficioMaximo);
    }

    static class Resultado {
        int beneficioMaximo;

        Resultado(int beneficioMaximo) {
            this.beneficioMaximo = beneficioMaximo;
        }
    }

    static Resultado calcularMaximoBeneficio(Proyecto[] proyectos, int presupuesto, int indice, int beneficioActual) {
        if (indice >= proyectos.length) {
            return new Resultado(beneficioActual);
        }

        // No incluir el proyecto actual
        Resultado sinActual = calcularMaximoBeneficio(proyectos, presupuesto, indice + 1, beneficioActual);

        // Incluir el proyecto actual
        Resultado conActual = new Resultado(0);
        if (proyectos[indice].costo <= presupuesto) {
            conActual = calcularMaximoBeneficio(proyectos, presupuesto - proyectos[indice].costo, indice + 1,
                                                beneficioActual + proyectos[indice].beneficio);
        }

        // Devolver el mejor resultado
        return sinActual.beneficioMaximo > conActual.beneficioMaximo ? sinActual : conActual;
    }
}
//O(2^n)
