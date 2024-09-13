package clase3;

public class Act2 {

    public static int[] encontrarDosMayores(int[] a) {
        return (encontrarDosMayores(a, 0, a.length - 1));
    }

    public static int[] encontrarDosMayores(int[] arr, int inicio, int fin) {

        // Caso base: si solo hay dos elementos, lo comparo y devuelvo en orden
        if (fin - inicio == 1) {
            if (arr[inicio] > arr[fin]) {
                return new int[]{arr[inicio], arr[fin]};
            } else {
                return new int[]{arr[fin], arr[inicio]};
            }
        }

        // Si hay un solo elemento, lo devuelvo como el mayor y el menor valor entero posible como segundo mayor
        if (inicio == fin) {
            return new int[]{arr[inicio], Integer.MIN_VALUE};
        }

        // Dividir la lista en dos mitades
        int medio = (inicio + fin) / 2;
        int[] mayoresIzq = encontrarDosMayores(arr, inicio, medio);
        int[] mayoresDer = encontrarDosMayores(arr, medio + 1, fin);

        // Combinar los dos resultados
        int mayor, segundoMayor;
        if (mayoresIzq[0] > mayoresDer[0]) {
            mayor = mayoresIzq[0];
            segundoMayor = Math.max(mayoresIzq[1], mayoresDer[0]); //con la funcion max elijo el mayor entre el menor de los mayores de la sublista izquierda y el mayor de la sublista derecha
        } else {
            mayor = mayoresDer[0];
            segundoMayor = Math.max(mayoresDer[1], mayoresIzq[0]); //con la funcion max elijo el mayor entre el menor de los mayores de la sublista derecha y el mayor de la sublista izquierda
        }

        return new int[]{mayor, segundoMayor};
    }

    // Como no hay ningun bucle while o for que traiga un coso intrínseco el costo se debe evaluar en base al largo del array, como
    // en el peor de los casos sería n, el coste del metodo encontrarDosMayores es O(n) y su tiempo todoal es de T(n)=n*c

    public static void main(String[] args) {
        int[] lista = {12, 5, 9, 21, 15, 30, 7};
        int[] resultado = encontrarDosMayores(lista);

        System.out.println("El número mayor es: " + resultado[0]);
        System.out.println("El segundo número mayor es: " + resultado[1]);
    }
    
}