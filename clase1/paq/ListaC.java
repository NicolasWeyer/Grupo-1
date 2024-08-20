package paq;

public class ListaC {

    public class Cliente{
        int id;
        String nombre;
        Cliente sig;
    }

    Cliente origen = null;

    public void Agregar(int num, String nom) { //costo constante
        Cliente nuevo = new Cliente();
        nuevo.id = num;
        nuevo.nombre = nom;
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

}
