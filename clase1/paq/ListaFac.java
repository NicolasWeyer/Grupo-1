package paq;

public class ListaFac {

    public class Factura{
        int idf; //id factura
        int idc; //id cliente
        int importe;
        Factura sig;
    }

    Factura origen = null;

    public void Agregar(int idF, int idC, int cant) { //costo constante
        Factura nuevo = new Factura();
        nuevo.idc = idC;
        nuevo.idf = idF;
        nuevo.importe = cant;
        nuevo.sig = origen;
        origen = nuevo;
    }

    public void Eliminar(int idF) { //costo lineal n por el while
        if (origen != null) {
            if (origen.idf == idF) {
                origen = origen.sig;
            } else {
                Factura aux = origen;
                while (aux.sig != null && aux.sig.idf != idF) {
                    aux = aux.sig;
                }
                if (aux.sig != null) {
                    aux.sig = aux.sig.sig;
                }
            }
        }
    }

    public Factura Recuperar() { //costo constante
        return origen;
    }

    public boolean ListaVacia() { //costo constante
        return (origen == null); 
    }

}
