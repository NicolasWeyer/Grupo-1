package paq;

public class ej1 {
    
    public static void main(String[] args) {
        
        //Punto a

        int max = 0;
        int [] arr = new int [10];
        arr[0] = 12;
        arr[1] = 9;
        arr[2] = 1;
        arr[3] = 4;

        for(int i = 0; i < arr.length; i++) {
            if (arr[i] > max) 
                max = arr[i];
        }

        System.out.println(max);



    }

}