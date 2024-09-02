package br.cefetmg.inf.llp1.lista09.p1068;
import java.util.Scanner;

class Nodo {
    char dado;
    Nodo proximoNodo;

    public Nodo(char dado) {
        this.dado = dado;
        this.proximoNodo = null;
    }
}

class PilhaLigada {
    private Nodo topoPilha;

    public PilhaLigada() {
        topoPilha = null;
    }

    public void adicionar(char dado) {
        Nodo novoNodo = new Nodo(dado);
        novoNodo.proximoNodo = topoPilha;
        topoPilha = novoNodo;
    }

    public char remover() {
        char dado = topoPilha.dado;
        topoPilha = topoPilha.proximoNodo;
        return dado;
    }

    public boolean estaVazia() {
        return topoPilha == null;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        while (entrada.hasNextLine()) {
            String sequencia = entrada.nextLine();
            if (sequenciaValida(sequencia)) {
                System.out.println("correct");
            } else {
                System.out.println("incorrect");
            }
        }
    }

    public static boolean sequenciaValida(String sequencia) {
        PilhaLigada pilha = new PilhaLigada();
        for (int i = 0; i < sequencia.length(); i++) {
            char simbolo = sequencia.charAt(i);
            if (simbolo == '(') {
                pilha.adicionar(simbolo);
            } else if (simbolo == ')') {
                if (pilha.estaVazia()) {
                    return false;
                }
                pilha.remover();
            }
        }
        return pilha.estaVazia();
    }
}