public class ListaFinal {

    public class elem{
        int idc; //id cliente
        String nom;
        int total;
        elem sig;
    }
    
    elem origen = null;

    public void Agregar(int idC, String nombre, int imp) { //costo constante
        elem nuevo = new elem();
        nuevo.idc = idC;
        nuevo.nom = nombre;
        nuevo.total = imp;
        nuevo.sig = origen;
        origen = nuevo;
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

}
