package clase3;

public class Act1 {

    public static Cliente maximo(Cliente[] cli) {
        Cliente max = new Cliente();
        return maximo(cli, 0, cli.length, max);
    }

    public static Cliente maximo(Cliente[] cli, int i, int f, Cliente resul) {
        if (i == f - 1) {
            return resul;
        } else {
            int mitad = (f + i) / 2;
            if (cli[mitad].scoring > resul.scoring) {
                resul = cli[mitad]; 
            }
            if (maximo(cli, i, mitad, resul).scoring > maximo(cli, mitad, f, resul).scoring) {
                return maximo(cli, i, mitad, resul);
            } else {
                System.out.println("hola");
                return maximo(cli, mitad, f, resul);
            }
        }
    }

    public static Cliente maxim(Lista list) {
        Cliente max = new Cliente();
        while (!list.ListaVacia()) {
            if(list.Recuperar().scoring > max.scoring) {
                max.scoring = list.Recuperar().scoring;
            }
            list.Eliminar(list.Recuperar().id);
        }
        return max; 
    }

    //El método máximo tiene costo 

    public static void main(String[] args) {
        
        Lista lista = new Lista();
        lista.Agregar(300, "Juan", 90); 
        lista.Agregar(301, "Osvaldo", 100);
        lista.Agregar(302, "Alberto", 70);

        Cliente uno = new Cliente();
        uno.id = 300;
        uno.nombre = "Juan";
        uno.scoring = 90;
        Cliente dos = new Cliente();
        dos.id = 301;
        dos.nombre = "Osvaldo";
        dos.scoring = 60;
        Cliente tres = new Cliente();
        tres.id = 302;
        tres.nombre = "Alberto";
        tres.scoring = 80;

        Cliente[] clientes = {uno, dos, tres}; 

        //hasta acá el costo es constante (c), ya que el método de agregar es de costo constante. 

        System.out.println(maximo(clientes).scoring); 

        //System.out.println(maximo(lista).scoring);

    }

}
