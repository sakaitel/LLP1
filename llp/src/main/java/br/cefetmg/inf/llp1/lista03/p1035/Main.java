/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.inf.llp1.lista03.p1035;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a, b, c, d;
        
        a = scan.nextInt();
        b = scan.nextInt();
        c = scan.nextInt();
        d = scan.nextInt();
        
        if((b > c) & (d > a) & (c+d > a+b) & (c >= 0) & (d >=0) & (a % 2 == 0)){
            System.out.println("Valores aceitos");
        }
        else
            System.out.println("Valores nao aceitos");
    }
}