/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.inf.llp1.lista03.p1038;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int codigo, qtde;
        double preco = 0, total;
        
        codigo = scan.nextInt();
        qtde = scan.nextInt();
        
        switch(codigo) {
            case 1:  preco = 4.0;
                break;
            case 2:  preco = 4.5;
                break;
            case 3:  preco = 5.0;
                break;
            case 4:  preco = 2.0;
                break;
            case 5:  preco = 1.0;
        }       
        total = preco * qtde;
        System.out.printf("Total: R$ %.2f\n", total);
    }
}