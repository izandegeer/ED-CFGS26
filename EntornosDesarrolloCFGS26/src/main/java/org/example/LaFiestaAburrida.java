package org.example;

import java.util.Scanner;

public class LaFiestaAburrida {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int numGente = teclado.nextInt();
        teclado.nextLine();


        for (int i = 0; i < numGente; i++) {

            System.out.print("\nSoy ");
            String nombre = teclado.nextLine();
            System.out.println("Hola, " + nombre);
        }
    }
}
