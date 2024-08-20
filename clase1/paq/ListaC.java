package paq;

public class ListaC {

    public class Cliente{
        int id;
        String nombre;
        Cliente sig;
    }

    Cliente origen = null;

    public void Agregar(int num, String nom) {
        Cliente nuevo = new Cliente();
        nuevo.id = num;
        nuevo.nombre = nom;
        nuevo.sig = origen;
        origen = nuevo;
    }

    public void Eliminar(int num) {
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

    public Cliente Recuperar() {
        return origen;
    }

}
