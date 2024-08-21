package paq;

public class ListaFinal {

    public class elem{
        int idc; //id cliente
        String nom;
        int total;
        elem sig;
    }
    
    elem origen = null;

    public void Agregar(int idC, String nombre, int imp) { //costo n + n por el pertenece y el while del else (costo lineal)
        if (!this.Pertenece(idC)) {
            elem nuevo = new elem();
            nuevo.idc = idC;
            nuevo.nom = nombre;
            nuevo.sig = origen;
            origen = nuevo;
        } else {
            elem aux = origen;
            while (aux.idc != idC) {
                aux = aux.sig;
            }
            aux.total += imp;
        }
    }

    public void Eliminar(int idC) { //costo lineal n por el while
        if (origen != null) {
            if (origen.idc == idC) {
                origen = origen.sig;
            } else {
                elem aux = origen;
                while (aux.sig != null && aux.sig.idc != idC) {
                    aux = aux.sig;
                }
                if (aux.sig != null) {
                    aux.sig = aux.sig.sig;
                }
            }
        }
    }

    public elem Recuperar() { //costo constante
        return origen;
    }

    public boolean ListaVacia() { //costo constante
        return (origen == null); 
    }

    private boolean Pertenece(int idC) {//costo lineal n por el while
        elem aux = origen;
		while (aux != null && aux.idc != idC) {
			aux = aux.sig;
		}
		return (aux != null); //aux va a ser null si recorrí toda la lista
    }

}
