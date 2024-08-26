public class ABB {

    public static class Nodo {
        int dato;
        Nodo izq, der;

        public Nodo(int dato) {
            this.dato = dato;
            izq = der = null;
        }
    }

    // Método para buscar un valor en el BST
    public Nodo BuscarABB(Nodo raiz, int x) {
        if (raiz == null || raiz.dato == x) {
            return raiz;
        } else if (x < raiz.dato) {
            return BuscarABB(raiz.izq, x);
        } else {
            return BuscarABB(raiz.der, x);
        }
    }

    private static int getHeight(Nodo raiz) {
        if (raiz == null) {
            return -1;
        } else {
            return 1 + Math.max(getHeight(raiz.izq), getHeight(raiz.der));
        }
    }

}


