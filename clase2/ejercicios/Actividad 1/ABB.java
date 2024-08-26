
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



}







