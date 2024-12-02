/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.inf.llp1.lista13.p1068.comLista;

import java.util.Scanner;

class NenhumItemException extends RuntimeException {
    public NenhumItemException(String mensagem) {
        super(mensagem);
    }
}

interface PilhaInterface<T> {
    void empilhar(T elemento);
    T desempilhar();
    T topo();
    boolean estaVazia();
    int tamanho();
}

class PilhaArray<T> implements PilhaInterface<T> {
    private T[] elementos;
    private int topo;

    @SuppressWarnings("unchecked")
    public PilhaArray(int capacidade) {
        elementos = (T[]) new Object[capacidade];
        topo = -1;
    }

    @Override
    public void empilhar(T elemento) {
        if (topo < elementos.length - 1) {
            elementos[++topo] = elemento;
        }
    }

    @Override
    public T desempilhar() {
        if (estaVazia()) {
            throw new NenhumItemException("A pilha está vazia.");
        }
        return elementos[topo--];
    }

    @Override
    public T topo() {
        if (estaVazia()) {
            throw new NenhumItemException("A pilha está vazia.");
        }
        return elementos[topo];
    }

    @Override
    public boolean estaVazia() {
        return topo == -1;
    }

    @Override
    public int tamanho() {
        return topo + 1;
    }
}

class PilhaEncadeada<T> implements PilhaInterface<T> {
    private No topo;
    private int tamanho;

    private class No {
        T dado;
        No proximo;

        No(T dado) {
            this.dado = dado;
            this.proximo = null;
        }
    }

    public PilhaEncadeada() {
        topo = null;
        tamanho = 0;
    }

    @Override
    public void empilhar(T elemento) {
        No novoNo = new No(elemento);
        novoNo.proximo = topo;
        topo = novoNo;
        tamanho++;
    }

    @Override
    public T desempilhar() {
        if (estaVazia()) {
            throw new NenhumItemException("A pilha está vazia.");
        }
        T valor = topo.dado;
        topo = topo.proximo;
        tamanho--;
        return valor;
    }

    @Override
    public T topo() {
        if (estaVazia()) {
            throw new NenhumItemException("A pilha está vazia.");
        }
        return topo.dado;
    }

    @Override
    public boolean estaVazia() {
        return topo == null;
    }

    @Override
    public int tamanho() {
        return tamanho;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (scan.hasNextLine()) {
            String expressao = scan.nextLine();

            if (verificarParenteses(new PilhaArray<>(1000), expressao)) {
                System.out.println("correct");
            } else {
                System.out.println("incorrect");
            }

            // if (verificarParenteses(new PilhaEncadeada<>(), expressao)) {
            //     System.out.println("correct");
            // } else {
            //     System.out.println("incorrect");
            // }
        }
    }

    public static boolean verificarParenteses(PilhaInterface<Integer> pilha, String expressao) {
        for (char ch : expressao.toCharArray()) {
            if (ch == '(') {
                pilha.empilhar(1);
            } else if (ch == ')') {
                if (pilha.estaVazia()) {
                    return false;
                }
                pilha.desempilhar();
            }
        }
        return pilha.estaVazia();
    }
}
