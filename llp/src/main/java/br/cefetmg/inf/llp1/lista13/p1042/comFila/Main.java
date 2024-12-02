package br.cefetmg.inf.llp1.lista13.p1042.comFila;

import java.util.Scanner;

class NenhumItemException extends RuntimeException {
    public NenhumItemException(String mensagem) {
        super(mensagem);
    }
}

interface FilaInterface<T> {
    int capacidade();
    int tamanho();
    boolean estaVazia();
    void enfileirar(T elemento);
    T desenfileirar();
}

class Fila<T> implements FilaInterface<T> {
    int capacidade;
    int tamanho = 0;

    public Fila(int capacidade) {
        this.capacidade = capacidade;
    }

    @Override
    public int capacidade() {
        return capacidade;
    }

    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public void enfileirar(T elemento) {}

    @Override
    public T desenfileirar() {
        return null;
    }
}

class FilaArray<T> extends Fila<T> {
    private T[] fila;
    private int inicio;
    private int fim;

    @SuppressWarnings("unchecked")
    public FilaArray(int capacidade) {
        super(capacidade);
        fila = (T[]) new Object[capacidade];
        inicio = 0;
        fim = -1;
    }

    @Override
    public void enfileirar(T elemento) {
        if (tamanho == capacidade) {
            System.out.println("Fila cheia");
            return;
        }
        fim = (fim + 1) % capacidade;
        fila[fim] = elemento;
        tamanho++;
    }

    @Override
    public T desenfileirar() {
        if (estaVazia()) {
            throw new NenhumItemException("A fila está vazia. Não é possível remover.");
        }
        T elementoRemovido = fila[inicio];
        inicio = (inicio + 1) % capacidade;
        tamanho--;
        return elementoRemovido;
    }
}

class FilaEncadeada<T> extends Fila<T> {
    private Nodo frente;
    private Nodo traseira;

    private class Nodo {
        T dado;
        Nodo proximo;

        Nodo(T dado) {
            this.dado = dado;
            proximo = null;
        }
    }

    public FilaEncadeada(int capacidade) {
        super(capacidade);
        frente = null;
        traseira = null;
    }

    @Override
    public void enfileirar(T elemento) {
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

    @Override
    public T desenfileirar() {
        if (estaVazia()) {
            throw new NenhumItemException("A fila está vazia. Não é possível remover.");
        }
        T elementoRemovido = frente.dado;
        frente = frente.proximo;
        if (frente == null) {
            traseira = null;
        }
        tamanho--;
        return elementoRemovido;
    }
}

class FilaCircular<T> extends Fila<T> {
    private T[] fila;
    private int inicio;
    private int fim;

    @SuppressWarnings("unchecked")
    public FilaCircular(int capacidade) {
        super(capacidade);
        fila = (T[]) new Object[capacidade];
        inicio = 0;
        fim = -1;
    }

    @Override
    public void enfileirar(T elemento) {
        if (tamanho == capacidade) {
            System.out.println("Fila cheia");
            return;
        }
        fim = (fim + 1) % capacidade;
        fila[fim] = elemento;
        tamanho++;
    }

    @Override
    public T desenfileirar() {
        if (estaVazia()) {
            throw new NenhumItemException("A fila está vazia. Não é possível remover.");
        }
        T elementoRemovido = fila[inicio];
        inicio = (inicio + 1) % capacidade;
        tamanho--;
        return elementoRemovido;
    }
}

class InsertionSort {
    public static <T extends Comparable<T>> void insercao(FilaInterface<T> fila) {
        if (fila.estaVazia()) {
            throw new NenhumItemException("A lista está vazia. Não é possível remover.");
        }

        T[] elementos = (T[]) new Comparable[fila.tamanho()];
        for (int i = 0; i < elementos.length; i++) {
            elementos[i] = fila.desenfileirar();
        }

        insertionSort(elementos);

        for (T elemento : elementos) {
            fila.enfileirar(elemento);
        }
    }

    private static <T extends Comparable<T>> void insertionSort(T[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            T chave = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].compareTo(chave) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = chave;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        FilaInterface<Integer> filaOriginal = new FilaArray<>(3);
        // FilaInterface<Integer> filaOriginal = new FilaCircular<>(3);
        // FilaInterface<Integer> filaOriginal = new FilaEncadeada<>(3);

        for (int i = 0; i < 3; i++) {
            int valor = scan.nextInt();
            filaOriginal.enfileirar(valor);
        }

        FilaInterface<Integer> filaOrdenada = copiarFila(filaOriginal);

        InsertionSort.insercao(filaOrdenada);

        mostrarFila(filaOrdenada);
        System.out.println();
        mostrarFila(filaOriginal);
    }

    public static <T> FilaInterface<T> copiarFila(FilaInterface<T> original) {
        FilaInterface<T> copia;

        if (original instanceof FilaArray) {
            copia = new FilaArray<>(original.capacidade());
        } else if (original instanceof FilaEncadeada) {
            copia = new FilaEncadeada<>(original.capacidade());
        } else {
            copia = new FilaCircular<>(original.capacidade());
        }

        int tamanho = original.tamanho();
        for (int i = 0; i < tamanho; i++) {
            T valor = original.desenfileirar();
            copia.enfileirar(valor);
            original.enfileirar(valor);
        }
        return copia;
    }

    public static <T> void mostrarFila(FilaInterface<T> fila) {
        int tamanho = fila.tamanho();
        for (int i = 0; i < tamanho; i++) {
            System.out.println(fila.desenfileirar());
        }
    }
}
