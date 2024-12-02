/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.inf.llp1.lista15.p2292;

import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));

        int casos = Integer.parseInt(leitor.readLine());

        for (int i = 0; i < casos; i++) {
            String linha = leitor.readLine();
            String[] partes = linha.split(" ");
            String painel = partes[0];
            long alternancias = Long.parseLong(partes[1]);

            char[] configuracao = painel.toCharArray();

            configuracao[0] = (alternancias % 2 == 0) ? configuracao[0] : inverter(configuracao[0]);

            for (int j = 1; j < configuracao.length; j++) {
                if (configuracao[j - 1] == 'X') {
                    configuracao[j] = inverter(configuracao[j]);
                }
            }

            System.out.println(new String(configuracao));
        }
    }

    private static char inverter(char c) {
        return (c == 'O') ? 'X' : 'O';
    }
}
