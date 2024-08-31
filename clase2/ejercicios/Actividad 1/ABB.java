
class Nodo {
    int dato;
    Nodo izq, der;

    public Nodo(int dato) {
        this.dato = dato;
        izq = der = null;
    }
}

public class ABB {

    private static int getHeight(Nodo raiz) {
        if(raiz==null) {
            return -1;
        } else {
            return 1+ Math.max(getHeight(raiz.izq), getHeight(raiz.der));
        }
    }





//Utilizando el siguiente main creamos un arbol de altura 3 de la forma:

    /*                    10            altura 0
                        /    \
                       5      20        altura 1
                      / \    /  \
                     3   7  15  25      altura 2
                                  \
                                  30    altura 3
    */

public static void main(String[] args) {
    ABB a = new ABB();
    // Crear un árbol de ejemplo
    Nodo raiz = new Nodo(10);
    raiz.izq = new Nodo(5);
    raiz.der = new Nodo(20);
    raiz.izq.izq = new Nodo(3);
    raiz.izq.der = new Nodo(7);
    raiz.der.izq = new Nodo(15);
    raiz.der.der = new Nodo(25);
    raiz.der.der.der = new Nodo(30);


    System.out.println("Altura del arbol: " + getHeight(raiz));

}}

//resultado por consola: Altura del arbol: 3





