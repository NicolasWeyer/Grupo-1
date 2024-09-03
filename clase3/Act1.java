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
            if (cli[f - 1].scoring >= cli[i].scoring) {
                resul = cli[f - 1]; 
            } else {
                resul = cli[i];
            }
            if (maximo(cli, i, mitad, resul).scoring > maximo(cli, mitad, f, resul).scoring) {
                return maximo(cli, i, mitad, resul);
            } else {
                return maximo(cli, mitad, f, resul);
            }
        }
    }

    //El método máximo tiene costo 

    public static void main(String[] args) {

        Cliente uno = new Cliente();
        uno.id = 300;
        uno.nombre = "Juan";
        uno.scoring = 100;
        Cliente dos = new Cliente();
        dos.id = 301;
        dos.nombre = "Osvaldo";
        dos.scoring = 140;
        Cliente tres = new Cliente();
        tres.id = 302;
        tres.nombre = "Alberto";
        tres.scoring = 110;
        Cliente cuatro = new Cliente();
        cuatro.id = 304;
        cuatro.nombre = "Jose";
        cuatro.scoring = 90;

        Cliente[] clientes = {uno, dos, tres, cuatro}; 

        //hasta acá el costo es constante (c). 

        System.out.println(maximo(clientes).scoring); 

    }

}
