package clase3;

public class Act1 {

    public static Cliente maximo(Lista list) {
        Cliente max = new Cliente();
        while (!list.ListaVacia()) {
            if(list.Recuperar().scoring > max.scoring) {
                max.scoring = list.Recuperar().scoring;
            }
            list.Eliminar(list.Recuperar().id);
        }
        return max; 
    }

    public static void main(String[] args) {
        
        Lista lista = new Lista();
        lista.Agregar(300, "Juan", 90);
        lista.Agregar(301, "Osvaldo", 100);
        lista.Agregar(302, "Alberto", 70);

        System.out.println(maximo().scoring);

    }

}
