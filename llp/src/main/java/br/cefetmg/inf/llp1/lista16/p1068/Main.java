/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.inf.llp1.lista16.p1068;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            while (scan.hasNextLine()) {
                String expressao = scan.nextLine();
                Stack<Character> pilha = new Stack<>();

                boolean correta = true;
                for (char c : expressao.toCharArray()) {
                    if (c == '(') {
                        pilha.push(c);
                    } else if (c == ')') {
                        if (pilha.isEmpty()) {
                            correta = false;
                            break;
                        }
                        pilha.pop();
                    }
                }

                if (correta && pilha.isEmpty()) {
                    System.out.println("correct");
                } else {
                    System.out.println("incorrect");
                }
            }
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
