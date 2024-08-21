package paq;

import java.math.BigInteger;

public class ej2 {

    public static void main(String[] args) {
        
        int a = 2147483647; //este es el límite de int
        long b = 999999999; //este es el límite de long
        BigInteger c = new BigInteger("999999999999999"); //actúa distinto, tiene más capacidad, y en este caso está leyendo un String
    }

}
