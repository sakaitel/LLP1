/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.inf.llp1.lista08.p1042;

import java.util.Scanner;

class FilaSimples {
    private int[] elementos;
    private int tamanho;
    private int capacidade;

    public FilaSimples(int capacidade) {
        this.capacidade = capacidade;
        elementos = new int[capacidade];
        tamanho = 0;
    }

    public void adicionar(int valor) {
        if (tamanho < capacidade) {
            elementos[tamanho] = valor;
            tamanho++;
        } else {
        }
    }

    public int remover() {
        if (tamanho > 0) {
            int valor = elementos[0];
            for (int i = 1; i < tamanho; i++) {
                elementos[i - 1] = elementos[i];
            }
            tamanho--;
            return valor;
        } else {
            return -1;
        }
    }

    public int[] obterElementos() {
        return elementos;
    }

    public int obterTamanho() {
        return tamanho;
    }
}

class FilaEncadeada {
    private class Nodo {
        int valor;
        Nodo proximo;
        public Nodo(int valor) {
            this.valor = valor;
        }
    }

    private Nodo frente, traseira;
    private int tamanho;

    public FilaEncadeada() {
        frente = traseira = null;
        tamanho = 0;
    }

    public void adicionar(int valor) {
        Nodo novo = new Nodo(valor);
        if (traseira != null) {
            traseira.proximo = novo;
        }
        traseira = novo;
        if (frente == null) {
            frente = novo;
        }
        tamanho++;
    }

    public int remover() {
        if (frente != null) {
            int valor = frente.valor;
            frente = frente.proximo;
            if (frente == null) {
                traseira = null;
            }
            tamanho--;
            return valor;
        } else {
            return -1;
        }
    }

    public int[] obterElementos() {
        int[] elementos = new int[tamanho];
        Nodo atual = frente;
        int i = 0;
        while (atual != null) {
            elementos[i++] = atual.valor;
            atual = atual.proximo;
        }
        return elementos;
    }

    public int obterTamanho() {
        return tamanho;
    }
}

class FilaCircular {
    private int[] elementos;
    private int inicio, fim, tamanho, capacidade;

    public FilaCircular(int capacidade) {
        this.capacidade = capacidade;
        elementos = new int[capacidade];
        inicio = 0;
        fim = -1;
        tamanho = 0;
    }

    public void adicionar(int valor) {
        if (tamanho < capacidade) {
            fim = (fim + 1) % capacidade;
            elementos[fim] = valor;
            tamanho++;
        }
    }

    public int remover() {
        if (tamanho > 0) {
            int valor = elementos[inicio];
            inicio = (inicio + 1) % capacidade;
            tamanho--;
            return valor;
        } else {
            return -1;
        }
    }

    public int[] obterElementos() {
        int[] copia = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            copia[i] = elementos[(inicio + i) % capacidade];
        }
        return copia;
    }

    public int obterTamanho() {
        return tamanho;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        executarFilaSimples(scanner);
        //executarFilaEncadeada(scanner);
        //executarFilaCircular(scanner);
        
    }

    public static void executarFilaSimples(Scanner scanner) {
        FilaSimples fila = new FilaSimples(3);
        for (int i = 0; i < 3; i++) {
            fila.adicionar(scanner.nextInt());
        }
        FilaSimples filaCopia = copiarFilaSimples(fila);
        ordenarFila(filaCopia.obterElementos(), filaCopia.obterTamanho());
        mostrarFila(filaCopia.obterElementos(), filaCopia.obterTamanho());
        System.out.println();
        mostrarFila(fila.obterElementos(), fila.obterTamanho());
    }

    public static void executarFilaEncadeada(Scanner scanner) {
        FilaEncadeada fila = new FilaEncadeada();
        for (int i = 0; i < 3; i++) {
            fila.adicionar(scanner.nextInt());
        }
        FilaEncadeada filaCopia = copiarFilaEncadeada(fila);
        ordenarFila(filaCopia.obterElementos(), filaCopia.obterTamanho());
        mostrarFila(filaCopia.obterElementos(), filaCopia.obterTamanho());
        System.out.println();
        mostrarFila(fila.obterElementos(), fila.obterTamanho());
    }

    public static void executarFilaCircular(Scanner scanner) {
        FilaCircular fila = new FilaCircular(3);
        for (int i = 0; i < 3; i++) {
            fila.adicionar(scanner.nextInt());
        }
        FilaCircular filaCopia = copiarFilaCircular(fila);
        ordenarFila(filaCopia.obterElementos(), filaCopia.obterTamanho());
        mostrarFila(filaCopia.obterElementos(), filaCopia.obterTamanho());
        System.out.println();
        mostrarFila(fila.obterElementos(), fila.obterTamanho());
    }

    public static FilaSimples copiarFilaSimples(FilaSimples original) {
        FilaSimples copia = new FilaSimples(original.obterTamanho());
        for (int i = 0; i < original.obterTamanho(); i++) {
            copia.adicionar(original.obterElementos()[i]);
        }
        return copia;
    }

    public static FilaEncadeada copiarFilaEncadeada(FilaEncadeada original) {
        FilaEncadeada copia = new FilaEncadeada();
        int[] elementos = original.obterElementos();
        for (int valor : elementos) {
            copia.adicionar(valor);
        }
        return copia;
    }

    public static FilaCircular copiarFilaCircular(FilaCircular original) {
        FilaCircular copia = new FilaCircular(original.obterTamanho());
        int[] elementos = original.obterElementos();
        for (int valor : elementos) {
            copia.adicionar(valor);
        }
        return copia;
    }

    public static void ordenarFila(int[] elementos, int tamanho) {
        for (int i = 0; i < tamanho - 1; i++) {
            for (int j = 0; j < tamanho - i - 1; j++) {
                if (elementos[j] > elementos[j + 1]) {
                    int temp = elementos[j];
                    elementos[j] = elementos[j + 1];
                    elementos[j + 1] = temp;
                }
            }
        }
    }

    public static void mostrarFila(int[] elementos, int tamanho) {
        for (int i = 0; i < tamanho; i++) {
            System.out.println(elementos[i]);
        }
    }
}
