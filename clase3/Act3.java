package clase3

public class Act3 {

    public static Cliente[] encontrarDosMayoresScorings(Cliente[] a){
        return encontrarDosMayoresScorings(a,0,a.length-1);
    }
    public static Cliente[] encontrarDosMayoresScorings(Cliente[] a, int inicio, int fin) {

        // Caso base: si solo hay dos elementos, lo comparo y devuelvo en orden
        if (fin - inicio == 1) {
            if (a[inicio].scoring > a[fin].scoring) {
                return new Cliente[]{a[inicio], a[fin]};
            } else {
                return new Cliente[]{a[fin], a[inicio]};
            }
        }


        if (inicio == fin) {
            return new Cliente[]{a[inicio], new Cliente()};
        }

        // Dividir la lista en dos mitades
        int medio = (inicio + fin) / 2;
        Cliente[] mayoresIzq = encontrarDosMayoresScorings(a, inicio, medio);
        Cliente[] mayoresDer = encontrarDosMayoresScorings(a, medio + 1, fin);

        // Combinar los dos resultados
        Cliente mayor;
        Cliente segundoMayor;
        if (mayoresIzq[0].scoring > mayoresDer[0].scoring) {
            mayor = mayoresIzq[0];
            if (mayoresIzq[1].scoring>= mayoresDer[0].scoring)
                segundoMayor = mayoresIzq[1];
            else
                segundoMayor = mayoresDer[0];
        } else {
            mayor = mayoresDer[0];
            if (mayoresDer[1].scoring>= mayoresIzq[0].scoring)
                segundoMayor = mayoresDer[1];
            else
                segundoMayor = mayoresIzq[0];

        }

        return new Cliente[]{mayor, segundoMayor};
    }

}