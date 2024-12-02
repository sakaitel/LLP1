/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.inf.llp1.lista15.p2866;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int casos = scanner.nextInt();
        scanner.nextLine();

        while (casos-- > 0) {
            String linha = scanner.nextLine();
            StringBuilder apenasMinusculas = new StringBuilder();

            for (char caractere : linha.toCharArray()) {
                if (Character.isLowerCase(caractere)) {
                    apenasMinusculas.append(caractere);
                }
            }

            System.out.println(apenasMinusculas.reverse());
        }

        scanner.close();
    }
}