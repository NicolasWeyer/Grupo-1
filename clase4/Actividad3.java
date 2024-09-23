import java.util.Arrays;
import java.util.Comparator;

class Articulo {
    int peso;
    int valor;
    double valorPorPeso;

    public Articulo(int peso, int valor) {
        this.peso = peso;
        this.valor = valor;
        this.valorPorPeso = (double) valor / peso;
    }
}

public class Actividad3 {

    public static double maximizarValor(Articulo[] articulos, int capacidad) {
        // Ordenar los artículos en orden descendente
        Arrays.sort(articulos, Comparator.comparingDouble(a -> -a.valorPorPeso));

        double valorTotal = 0;
        for (Articulo articulo : articulos) {
            if (capacidad > 0 && articulo.peso <= capacidad) {
                // Si el artículo cabe completamente, lo tomamos
                capacidad -= articulo.peso;
                valorTotal += articulo.valor;
                System.out.println("Se ha agregado el artículo completo con valor: " + articulo.valor);
            } else if (capacidad > 0) {
                // Si no cabe completamente, tomamos una fracción del artículo
                double fraccion = (double) capacidad / articulo.peso;
                valorTotal += articulo.valor * fraccion;
                System.out.println("Se ha agregado una fracción del artículo con valor parcial: " + articulo.valor * fraccion);
                capacidad = 0;  // Ya no cabe más
            }
        }

        return valorTotal;
    }

    public static void main(String[] args) {
        Articulo[] articulos = {
            new Articulo(10, 60),
            new Articulo(20, 100),
            new Articulo(30, 120)
        };

        int capacidad = 50;  // Capacidad del camión

        double valorMaximo = maximizarValor(articulos, capacidad);
        System.out.println("El valor máximo que se puede obtener es: " + valorMaximo);
    }
}
//O(n log n)