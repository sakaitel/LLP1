/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.inf.llp1.lista03.p1042;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a, b, c, maior = 0, menor = 0, meio = 0;
        
        a = scan.nextInt();
        b = scan.nextInt();
        c = scan.nextInt();
        
        if(a >= b & a >= c){
            maior = a;
                if(b >= c){
                    meio = b;
                    menor = c;
                }
                else{
                    meio = c;
                    menor = b;
                }
        }
        else if(b >= a & b >= c){
            maior = b;
                if(a >= c){
                    meio = a;
                    menor = c;
                }
                else{
                    meio = c;
                    menor = a;
                }
        }
        else{
            maior = c;
                if(a >= b){
                    meio = a;
                    menor = b;
                }
                else{
                    meio = b;
                    menor = a;
                }
        }
        System.out.printf("%d\n%d\n%d\n\n%d\n%d\n%d\n", menor, meio, maior, a, b, c);
    }
}