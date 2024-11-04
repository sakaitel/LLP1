package br.cefetmg.inf.llp1.lista14.deque;

import java.util.Scanner;

class ItemNaoEncontradoException extends RuntimeException {
    public ItemNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}

class PosicaoInvalidaException extends RuntimeException {
    public PosicaoInvalidaException(String mensagem) {
        super(mensagem);
    }
}

class Deque<T extends Comparable<T>> {
    private class No {
        T valor;
        No proximo;
        No anterior;

        public No() {
            this(null, null, null);
        }

        public No(T valor) {
            this(valor, null, null);
        }

        public No(T valor, No proximo, No anterior) {
            this.valor = valor;
            this.proximo = proximo;
            this.anterior = anterior;
        }
    }

    private No primeiro;
    private No ultimo;
    private int tamanho;

    public Deque() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public int tamanho() {
        return tamanho;
    }

    public boolean estaVazio() {
        return tamanho == 0;
    }

    public void adicionarNoInicio(T valor) {
        No novoNo = new No(valor, primeiro, null);
        if (estaVazio()) {
            ultimo = novoNo;
        } else {
            primeiro.anterior = novoNo;
        }
        primeiro = novoNo;
        tamanho++;
    }

    public void adicionarNoFim(T valor) {
        No novoNo = new No(valor, null, ultimo);
        if (estaVazio()) {
            primeiro = novoNo;
        } else {
            ultimo.proximo = novoNo;
        }
        ultimo = novoNo;
        tamanho++;
    }

    public T removerDoInicio() {
        if (estaVazio()) {
            throw new ItemNaoEncontradoException("Lista vazia.");
        }
        T valor = primeiro.valor;
        primeiro = primeiro.proximo;
        if (primeiro != null) {
            primeiro.anterior = null;
        } else {
            ultimo = null;
        }
        tamanho--;
        return valor;
    }

    public T removerDoFim() {
        if (estaVazio()) {
            throw new ItemNaoEncontradoException("Lista vazia.");
        }
        T valor = ultimo.valor;
        ultimo = ultimo.anterior;
        if (ultimo != null) {
            ultimo.proximo = null;
        } else {
            primeiro = null;
        }
        tamanho--;
        return valor;
    }

    public T obterInicio() {
        if (estaVazio()) {
            throw new ItemNaoEncontradoException("Lista vazia");
        }
        return primeiro.valor;
    }

    public T obterFim() {
        if (estaVazio()) {
            throw new ItemNaoEncontradoException("Lista vazia");
        }
        return ultimo.valor;
    }

    public T obter(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new PosicaoInvalidaException("Posição inválida: " + posicao);
        }
        No atual = primeiro;
        for (int i = 0; i < posicao; i++) {
            atual = atual.proximo;
        }
        return atual.valor;
    }

    public void definir(int posicao, T valor) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new PosicaoInvalidaException("Posição inválida: " + posicao);
        }
        No atual = primeiro;
        for (int i = 0; i < posicao; i++) {
            atual = atual.proximo;
        }
        atual.valor = valor;
    }
}

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        Deque<Integer> listaOriginal = new Deque<>();
        Deque<Integer> listaOrdenada = new Deque<>();

        listaOriginal.adicionarNoFim(a);
        listaOriginal.adicionarNoFim(b);
        listaOriginal.adicionarNoFim(c);

        listaOrdenada.adicionarNoFim(a);
        listaOrdenada.adicionarNoFim(b);
        listaOrdenada.adicionarNoFim(c);

        ordenarPorBolha(listaOrdenada);

        for (int i = 0; i < listaOrdenada.tamanho(); i++) {
            System.out.println(listaOrdenada.obter(i));
        }

        System.out.println();

        for (int i = 0; i < listaOriginal.tamanho(); i++) {
            System.out.println(listaOriginal.obter(i));
        }
    }

    private static void ordenarPorBolha(Deque<Integer> lista) {
        int n = lista.tamanho();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (lista.obter(j) > lista.obter(j + 1)) {
                    int temp = lista.obter(j);
                    lista.definir(j, lista.obter(j + 1));
                    lista.definir(j + 1, temp);
                }
            }
        }
    }
}
