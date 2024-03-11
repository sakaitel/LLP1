/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.inf.llp1.lista03.p1052;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int mes = 0;
        String mesExtenso = "January";
        
        mes = scan.nextInt();
        
        switch(mes) {
            case 1:  mesExtenso = "January";
                break;
            case 2:  mesExtenso = "February";
                break;
            case 3:  mesExtenso = "March";
                break;
            case 4:  mesExtenso = "April";
                break;
            case 5:  mesExtenso = "May";
                break;
            case 6:  mesExtenso = "June";
                break;
            case 7:  mesExtenso = "July";
                break;
            case 8:  mesExtenso = "August";
                break;
            case 9:  mesExtenso = "September";
                break;
            case 10:  mesExtenso = "October";
                break;
            case 11:  mesExtenso = "November";
                break;
            case 12:  mesExtenso = "December";
                break;
        }       
        System.out.println(mesExtenso);
    }
}