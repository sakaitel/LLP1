package br.cefetmg.inf.llp1.lista12.p1042;

import java.util.Scanner;

class NenhumItemException extends RuntimeException {
    public NenhumItemException(String mensagem) {
        super(mensagem);
    }
}

interface FilaInterface {
    int capacidade();
    int tamanho();
    boolean estaVazia();
    void enfileirar(Object elemento);
    Object desenfileirar();
}

class Fila {
    int capacidade;
    int tamanho = 0;

    public Fila(int capacidade) {
        this.capacidade = capacidade;
    }

    public int capacidade() {
        return capacidade;
    }

    public int tamanho() {
        return tamanho;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public void enfileirar(Object elemento) {
        // Implementação vai ser feita nas subclasses
    }

    public Object desenfileirar() {
        return null;  // Implementação vai ser feita nas subclasses
    }
}

class FilaArray extends Fila {
    private Object[] fila;
    private int inicio;
    private int fim;

    public FilaArray(int capacidade) {
        super(capacidade);
        fila = new Object[capacidade];
        inicio = 0;
        fim = -1;
    }

    public void enfileirar(Object elemento) {
        if (tamanho == capacidade) {
            System.out.println("Fila cheia");
            return;
        }
        fim = (fim + 1) % capacidade;
        fila[fim] = elemento;
        tamanho++;
    }

    public Object desenfileirar() {
        if (estaVazia()) {
            throw new NenhumItemException("Fila vazia");
        }
        Object elemento = fila[inicio];
        inicio = (inicio + 1) % capacidade;
        tamanho--;
        return elemento;
    }
}

class FilaEncadeada extends Fila {
    private Nodo frente;
    private Nodo traseira;

    private class Nodo {
        Object dado;
        Nodo proximo;

        Nodo(Object dado) {
            this.dado = dado;
            proximo = null;
        }
    }

    public FilaEncadeada(int capacidade) {
        super(capacidade);
        frente = null;
        traseira = null;
    }

    public void enfileirar(Object elemento) {
        if (tamanho == capacidade) {
            System.out.println("Fila cheia");
            return;
        }
        Nodo novoNodo = new Nodo(elemento);
        if (estaVazia()) {
            frente = novoNodo;
        } else {
            traseira.proximo = novoNodo;
        }
        traseira = novoNodo;
        tamanho++;
    }

    public Object desenfileirar() {
        if (estaVazia()) {
            throw new NenhumItemException("Fila vazia");
        }
        Object elemento = frente.dado;
        frente = frente.proximo;
        if (frente == null) {
            traseira = null;
        }
        tamanho--;
        return elemento;
    }
}

class FilaCircular extends Fila {
    private Object[] fila;
    private int inicio;
    private int fim;

    public FilaCircular(int capacidade) {
        super(capacidade);
        fila = new Object[capacidade];
        inicio = 0;
        fim = -1;
    }

    public void enfileirar(Object elemento) {
        if (tamanho == capacidade) {
            System.out.println("Fila cheia");
            return;
        }
        fim = (fim + 1) % capacidade;
        fila[fim] = elemento;
        tamanho++;
    }

    public Object desenfileirar() {
        if (estaVazia()) {
            throw new NenhumItemException("Fila vazia");
        }
        Object elemento = fila[inicio];
        inicio = (inicio + 1) % capacidade;
        tamanho--;
        return elemento;
    }
}

class InsertionSort {
    public static void insercao(FilaInterface fila) {
        if (fila.estaVazia()) {
            throw new NenhumItemException("Fila vazia");
        }

        Object[] elementos = new Object[fila.tamanho()];
        for (int i = 0; i < elementos.length; i++) {
            elementos[i] = fila.desenfileirar();
        }

        for (int i = 1; i < elementos.length; i++) {
            Comparable chave = (Comparable) elementos[i];
            int j = i - 1;
            while (j >= 0 && ((Comparable) elementos[j]).compareTo(chave) > 0) {
                elementos[j + 1] = elementos[j];
                j--;
            }
            elementos[j + 1] = chave;
        }

        for (Object elemento : elementos) {
            fila.enfileirar(elemento);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Escolha uma das opções abaixo
        FilaInterface filaOriginal = new FilaArray(3);
        // FilaInterface filaOriginal = new FilaEncadeada(3);
        // FilaInterface filaOriginal = new FilaCircular(3);

        for (int i = 0; i < 3; i++) {
            int valor = scan.nextInt();
            filaOriginal.enfileirar(valor);
        }

        FilaInterface filaOrdenada = copiarFila(filaOriginal);
        InsertionSort.insercao(filaOrdenada);

        mostrarFila(filaOrdenada);
        System.out.println();
        mostrarFila(filaOriginal);
    }

    public static FilaInterface copiarFila(FilaInterface original) {
        FilaInterface copia;
        if (original instanceof FilaArray) {
            copia = new FilaArray(original.capacidade());
        } else if (original instanceof FilaEncadeada) {
            copia = new FilaEncadeada(original.capacidade());
        } else {
            copia = new FilaCircular(original.capacidade());
        }

        for (int i = 0; i < original.tamanho(); i++) {
            Object valor = original.desenfileirar();
            copia.enfileirar(valor);
            original.enfileirar(valor);
        }
        return copia;
    }

    public static void mostrarFila(FilaInterface fila) {
        for (int i = 0; i < fila.tamanho(); i++) {
            System.out.println(fila.desenfileirar());
        }
    }
}
