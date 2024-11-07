package clase11;

public class Act_3 {
    static int N = 4; 

    public static boolean esSeguro(int oficina[][], int fila, int col) {
        for (int i = 0; i < N; i++) {
            if (oficina[fila][i] == 1 || oficina[i][col] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void diseñar() {
        int oficina[][] = new int[N][N]; 
        colocarEquipo(oficina, 0, 0, 0); 
    }

    //Se puede usar esta misma función para las compus y las impresoras 
    public static boolean colocarEquipo(int oficina[][], int fila, int col, int equiposColocados) {
        if (equiposColocados == 4) { 
            imprimirOficina(oficina);
            return true;
        }
        for (int i = fila; i < N; i++) {
            for (int j = col; j < N; j++) {
                if (esSeguro(oficina, i, j)) {
                    oficina[i][j] = 1;
                    colocarEquipo(oficina, i, j + 1, equiposColocados + 1);
                    oficina[i][j] = 0;
                }
            }
            col = 0; 
        }
        return false; 
    }

    public static void imprimirOficina(int oficina[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (oficina[i][j] == 1) {
                    System.out.print("R ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        diseñar();
    }
}
