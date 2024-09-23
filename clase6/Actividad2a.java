import java.util.ArrayList;
import java.util.List;

public class Actividad2a {
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

        Resultado resultado = encontrarValorMaximo(objetos, capacidad, 0, 0);
        System.out.println("Valor máximo: " + resultado.valorMaximo);
        System.out.println("Objetos en la mochila: " + resultado.objetos);
    }

    static class Resultado {
        int valorMaximo;
        List<Integer> objetos;

        Resultado(int valorMaximo, List<Integer> objetos) {
            this.valorMaximo = valorMaximo;
            this.objetos = objetos;
        }
    }

    static Resultado encontrarValorMaximo(Objeto[] objetos, int capacidad, int indice, int valorActual) {
        if (indice >= objetos.length || capacidad <= 0) {
            return new Resultado(valorActual, new ArrayList<>());
        }

        // No incluir el objeto actual
        Resultado sinActual = encontrarValorMaximo(objetos, capacidad, indice + 1, valorActual);

        // Incluir el objeto actual
        Resultado conActual = new Resultado(0, new ArrayList<>());
        if (objetos[indice].peso <= capacidad) {
            conActual = encontrarValorMaximo(objetos, capacidad - objetos[indice].peso, indice + 1,
                                              valorActual + objetos[indice].valor);
            conActual.objetos.add(indice + 1); // Agregar el objeto actual
        }

        // Comparar y devolver el mejor resultado
        return sinActual.valorMaximo > conActual.valorMaximo ? sinActual : conActual;
    }
}
