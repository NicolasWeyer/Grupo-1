package paq;

  public class Promedio {

    public static void main(String[] args) {
      int suma = 0; //1
      int total = 0; //1
      for (int i = 0; i<matriz.length; i++){ //1 + 2.(n+1) + n
        for (int j = 0; i<matriz[i].length;j++){ // n . (1 + 2.(n+1) + n)
          suma+= matriz[i][j]; //2n
          total++; //n
        }
      }
      int promedio = suma/total; //2

  }
}
// f(n) = 1 + 1 + 1 + 2 . (n+1) + n + n .[(1 + 2.(n+1) + n) + 2n + n] + 2
// f(n) = 5 + 2n + 2 + n + n . (3 + 6n) = 7 + 3n + 6n^2 + 3n 
// f(n) = 6n^2 + 6n + 7 