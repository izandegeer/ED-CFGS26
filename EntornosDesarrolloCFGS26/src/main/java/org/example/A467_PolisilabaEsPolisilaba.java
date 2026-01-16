package org.example;

import java.util.Scanner;

public class A467_PolisilabaEsPolisilaba {
    public static void main(String[] args) {
        System.out.println("*** TAUTOLOGIA ***");
        System.out.println("------------------");

        Scanner teclado = new Scanner(System.in);

        int numCasos = teclado.nextInt();
        teclado.nextLine();

        int contador = 0;

        for (int i = 0; i < numCasos; i++) {
            String cadena = teclado.nextLine().trim();
            String[] cadenaV = cadena.split(" ");

            if (cadenaV.length >= 3 && cadenaV[0].equals(cadenaV[2])) {
                contador++;
            }

            if (contador > 0) {
                System.out.println("TAUTOLOGIA");
                contador = 0;
            } else {
                System.out.println("NO TAUTOLOGIA");
            }
        }

    }
}
