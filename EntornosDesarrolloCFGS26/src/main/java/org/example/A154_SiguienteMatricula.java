package org.example;

import java.util.Scanner;

public class A154_SiguienteMatricula {
    public static void main(String[] args) {
        System.out.println("*** MATRÍCULA ***");
        System.out.println("-----------------");

        Scanner teclado = new Scanner(System.in);

        String matricula = "";
        do {
            matricula = teclado.nextLine();
            String[] matriculaV = matricula.split(" ");

//            if (matriculaV[1]) { // ERROR 1: Tipos incompatibeles
//                System.out.println("Hola!");
//            }

            System.out.println(matriculaV[0] + " " + matriculaV[1]);
//            System.out.println(paco); // ERROR 2: Error de compilación
        } while (!matricula.equals("9999 ZZZ"));
    }

    public static void convertirMatricula(String[] matriculaV) {

    }
}
