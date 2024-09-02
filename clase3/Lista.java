package clase3;

public class Lista {
    
    Cliente origen = null;

    public void Agregar(int num, String nom, float score) { //costo constante
        Cliente nuevo = new Cliente();
        nuevo.id = num;
        nuevo.nombre = nom;
        nuevo.scoring = score;
        nuevo.sig = origen;
        origen = nuevo;
    }

    public void Eliminar(int num) {//costo lineal n por el while 
        if (origen != null) {
            if (origen.id == num) {
                origen = origen.sig;
            } else {
                Cliente aux = origen;
                while (aux.sig != null && aux.sig.id != num) {
                    aux = aux.sig;
                }
                if (aux.sig != null) {
                    aux.sig = aux.sig.sig;
                }
            }
        }
    }

    public Cliente Recuperar() { //costo constante
        return origen;
    }

    public boolean ListaVacia() { //costo constante
        return (origen == null); 
    }
}
