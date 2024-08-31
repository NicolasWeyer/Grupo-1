
public class BusquedaBinaria {

    public static int busquedaBinaria(int[] arreglo, int objetivo) {
        int izquierda = 0;
        int derecha = arreglo.length - 1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            if (arreglo[medio] == objetivo) {
                return medio; // Retorna el índice del objetivo
            }
            if (arreglo[medio] < objetivo) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }
        return -1;
    }

    public static int busquedaBinariarec(int[] a, int n) {
	    return busquedaBinariarec(a, 0, a.length-1,n);
	}
	public static int busquedaBinariarec(int[] a, int i, int f, int n) {
		if(i>f) {
			return -1;
		}
		int medio = i+ (f-i)/2;
		System.out.println(medio);
		if(a[medio] == n) {
			return medio;
		} else if (a[medio] > n) {
			return busquedaBinariarec(a, i, medio-1, n);
		} else {
			return busquedaBinariarec(a, medio+1, f, n);
		}
	}

// Utilizando el siguiente main con el arreglo: {22, 31, 5, 47, 19, 11, 100}
    public static void main(String[] args) {

        int[] arreglo = {5, 11, 19, 20, 22, 31, 47, 100};
        int objetivo = 19;
        int resultado = busquedaBinaria(arreglo, objetivo);

        if (resultado == -1) {
            System.out.println("Elemento no encontrado en el arreglo.");
        } else {
            System.out.println("Elemento encontrado en el índice: " + resultado);
        }

        int resultadorec = busquedaBinariarec(arreglo, objetivo);

        if (resultadorec == -1) {
            System.out.println("Elemento no encontrado en el arreglo.");
        } else {
            System.out.println("Elemento encontrado en el índice: " + resultadorec);
        }
    }
// Si el numero que busco es el 19 el resultado por consola es: Elemento encontrado en el indice: 4

// Si el numero que busco es el 10 el resultado por consola es: Elemento no encontrado en el arreglo

}