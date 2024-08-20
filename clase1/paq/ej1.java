package paq;

public class ej1 {
    
    public static void main(String[] args) {
        
        //Punto a

        int max = 0; //1
        int [] arr = new int [10]; //1
        arr[0] = 12; //1
        arr[1] = 9; //1
        arr[2] = 1; //1
        arr[3] = 4; //1

        for(int i = 0; i < arr.length; i++) { //1 + 2(n + 1) + n = 3n + 3
            if (arr[i] > max) //2n
                max = arr[i]; //2
        }

        System.out.println(max);

        //aprox = 5n + 11 (el if es n por el for, no porque el comando if sea un ciclo)
        //5n + 11 <= cn, n = 5, c = 12
        // 5/5 + 11 = 12 <= 12, g(n) pertenece a O(n) ---> orden lineal


        //Punto b
        //Sin Maps (lista)

        ListaC clientes = new ListaC();
        ListaFac facturas = new ListaFac();
        ListaFinal fin = new ListaFinal();

        


    }

}