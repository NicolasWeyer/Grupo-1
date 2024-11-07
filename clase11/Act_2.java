package clase11;

public class Act_2 {
    static int N = 4; 

    public static boolean esSeguro(int habitacion[][], int fila, int col) {
        for (int i = 0; i < N; i++) {
            if (habitacion[fila][i] == 1 || habitacion[i][col] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void diseñar() {
        int habitacion[][] = new int[N][N]; 
        colocarMueble(habitacion, 0, 0, 0); 
    }

    public static boolean colocarMueble(int habitacion[][], int fila, int col, int mueblesColocados) {
        if (mueblesColocados == 2) { 
            imprimirHabitacion(habitacion);
            return true;
        }
        for (int i = fila; i < N; i++) {
            for (int j = col; j < N; j++) {
                if (esSeguro(habitacion, i, j)) {
                    habitacion[i][j] = 1;
                    colocarMueble(habitacion, i, j + 1, mueblesColocados + 1);
                    habitacion[i][j] = 0;
                }
            }
            col = 0; 
        }
        return false; 
    }

    public static void imprimirHabitacion(int habitacion[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (habitacion[i][j] == 1) {
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
