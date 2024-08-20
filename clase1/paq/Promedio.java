package paq;

  public class Promedio {
    int suma = 0;
    int total = 0;
    for (int i = 0; i<matriz.length; i++){
      for (int j = 0; i<matriz[i].length;j++){
        suma+= matriz[i][j];
        total++;
      }
    }
    double promedio = (double) suma/total;
  }
