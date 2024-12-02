package br.cefetmg.inf.llp1.lista11.p1068;
import java.util.Scanner;

interface PilhaInterface {
    void empilhar(Object elemento);
    Object desempilhar();
    Object topo();
    boolean estaVazia();
    boolean estaCheia();
    int tamanho();
}

class PilhaArray implements PilhaInterface {
    private Object[] elementos;
    private int topo;
    private int capacidade;

    public PilhaArray(int capacidade) {
        this.capacidade = capacidade;
        elementos = new Object[capacidade];
        topo = -1;
    }

    @Override
    public void empilhar(Object elemento) {
        if (estaCheia()) {
            System.out.println("Pilha cheia");
            return;
        }
        elementos[++topo] = elemento;
    }

    @Override
    public Object desempilhar() {
        if (estaVazia()) {
            System.out.println("Pilha vazia");
            return null;
        }
        return elementos[topo--];
    }

    @Override
    public Object topo() {
        if (estaVazia()) {
            System.out.println("Pilha vazia");
            return null;
        }
        return elementos[topo];
    }

    @Override
    public boolean estaVazia() {
        return topo == -1;
    }

    @Override
    public boolean estaCheia() {
        return topo == capacidade - 1;
    }

    @Override
    public int tamanho() {
        return topo + 1;
    }
}

class PilhaEncadeada implements PilhaInterface {
    private No topo;
    private int tamanho;

    private class No {
        Object dado;
        No proximo;

        No(Object dado) {
            this.dado = dado;
            this.proximo = null;
        }
    }

    public PilhaEncadeada() {
        topo = null;
        tamanho = 0;
    }

    @Override
    public void empilhar(Object elemento) {
        No novoNo = new No(elemento);
        novoNo.proximo = topo;
        topo = novoNo;
        tamanho++;
    }

    @Override
    public Object desempilhar() {
        if (estaVazia()) {
            System.out.println("Pilha vazia");
            return null;
        }
        Object valor = topo.dado;
        topo = topo.proximo;
        tamanho--;
        return valor;
    }

    @Override
    public Object topo() {
        if (estaVazia()) {
            System.out.println("Pilha vazia");
            return null;
        }
        return topo.dado;
    }

    @Override
    public boolean estaVazia() {
        return topo == null;
    }

    @Override
    public boolean estaCheia() {
        return false; 
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

          
            if (verificarParenteses(new PilhaArray(1000), expressao)) {
                System.out.println("correct");
            } else {
                System.out.println("incorrect");
            }

            if (verificarParenteses(new PilhaEncadeada(), expressao)) {
                System.out.println("correct");
            } else {
                System.out.println("incorrect");
            }
        }
    }

    public static boolean verificarParenteses(PilhaInterface pilha, String expressao) {
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
