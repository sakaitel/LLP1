package br.cefetmg.inf.llp1.lista10.p1068;

import java.util.Scanner;
import java.util.Arrays;

enum StatusLista { SUCESSO, POSICAOINVALIDA }

interface ListaGenerica {
    int tamanho();
    boolean vazia();
    void inserirInicio(Integer item);
    void inserirFim(Integer item);
    StatusLista inserir(Integer item, int posicao);
    Integer removerInicio();
    Integer removerFim();
    Integer remover(int posicao);
    Integer obterInicio();
    Integer obterFim();
    Integer obter(int posicao);
    int pesquisar(Integer item);
}

class ListaSimplesmenteEncadeada implements ListaGenerica {

    class No {
        Integer item;
        No proximo;

        public No() {
            this(null, null);
        }

        public No(Integer item) {
            this(item, null);
        }

        public No(Integer item, No proximo) {
            this.item = item;
            this.proximo = proximo;
        }
    }

    private No primeiro = null;
    private int tamanho = 0;

    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public boolean vazia() {
        return primeiro == null;
    }

    @Override
    public void inserirInicio(Integer item) {
        No novoNo = new No(item);
        novoNo.proximo = primeiro;
        primeiro = novoNo;
        tamanho++;
    }

    @Override
    public void inserirFim(Integer item) {
        No novoNo = new No(item);
        if (vazia()) {
            primeiro = novoNo;
        } else {
            No atual = primeiro;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNo;
        }
        tamanho++;
    }

    @Override
    public StatusLista inserir(Integer item, int posicao) {
        if (posicao < 0 || posicao > tamanho) {
            return StatusLista.POSICAOINVALIDA;
        }

        if (posicao == 0) {
            inserirInicio(item);
        } else {
            No novoNo = new No(item);
            No atual = primeiro;
            for (int i = 0; i < posicao - 1; i++) {
                atual = atual.proximo;
            }
            novoNo.proximo = atual.proximo;
            atual.proximo = novoNo;
            tamanho++;
        }

        return StatusLista.SUCESSO;
    }

    @Override
    public Integer removerInicio() {
        if (vazia()) {
            return null;
        }
        Integer item = primeiro.item;
        primeiro = primeiro.proximo;
        tamanho--;
        return item;
    }

    @Override
    public Integer removerFim() {
        if (vazia()) {
            return null;
        }

        if (tamanho == 1) {
            return removerInicio();
        }

        No atual = primeiro;
        while (atual.proximo.proximo != null) {
            atual = atual.proximo;
        }

        Integer item = atual.proximo.item;
        atual.proximo = null;
        tamanho--;
        return item;
    }

    @Override
    public Integer remover(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            return null;
        }

        if (posicao == 0) {
            return removerInicio();
        }

        No atual = primeiro;
        for (int i = 0; i < posicao - 1; i++) {
            atual = atual.proximo;
        }

        Integer item = atual.proximo.item;
        atual.proximo = atual.proximo.proximo;
        tamanho--;
        return item;
    }

    @Override
    public Integer obterInicio() {
        if (vazia()) {
            return null;
        }
        return primeiro.item;
    }

    @Override
    public Integer obterFim() {
        if (vazia()) {
            return null;
        }

        No atual = primeiro;
        while (atual.proximo != null) {
            atual = atual.proximo;
        }
        return atual.item;
    }

    @Override
    public Integer obter(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            return null;
        }

        No atual = primeiro;
        for (int i = 0; i < posicao; i++) {
            atual = atual.proximo;
        }
        return atual.item;
    }

    @Override
    public int pesquisar(Integer item) {
        No atual = primeiro;
        int posicao = 0;
        while (atual != null) {
            if (atual.item.equals(item)) {
                return posicao;
            }
            atual = atual.proximo;
            posicao++;
        }
        return -1;
    }
}

class ListaDuplamenteEncadeada implements ListaGenerica {

    class No {
        Integer item;
        No proximo;
        No anterior;

        public No() {
            this(null, null, null);
        }

        public No(Integer item) {
            this(item, null, null);
        }

        public No(Integer item, No proximo, No anterior) {
            this.item = item;
            this.proximo = proximo;
            this.anterior = anterior;
        }
    }

    private No primeiro = null;
    private No ultimo = null;
    private int tamanho = 0;

    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public boolean vazia() {
        return primeiro == null;
    }

    @Override
    public void inserirInicio(Integer item) {
        No novoNo = new No(item, primeiro, null);
        if (vazia()) {
            ultimo = novoNo;
        } else {
            primeiro.anterior = novoNo;
        }
        primeiro = novoNo;
        tamanho++;
    }

    @Override
    public void inserirFim(Integer item) {
        No novoNo = new No(item, null, ultimo);
        if (vazia()) {
            primeiro = novoNo;
        } else {
            ultimo.proximo = novoNo;
        }
        ultimo = novoNo;
        tamanho++;
    }

    @Override
    public StatusLista inserir(Integer item, int posicao) {
        if (posicao < 0 || posicao > tamanho) {
            return StatusLista.POSICAOINVALIDA;
        }

        if (posicao == 0) {
            inserirInicio(item);
        } else if (posicao == tamanho) {
            inserirFim(item);
        } else {
            No atual = primeiro;
            for (int i = 0; i < posicao - 1; i++) {
                atual = atual.proximo;
            }
            No novoNo = new No(item, atual.proximo, atual);
            atual.proximo.anterior = novoNo;
            atual.proximo = novoNo;
            tamanho++;
        }

        return StatusLista.SUCESSO;
    }

    @Override
    public Integer removerInicio() {
        if (vazia()) {
            return null;
        }
        Integer item = primeiro.item;
        primeiro = primeiro.proximo;
        if (primeiro != null) {
            primeiro.anterior = null;
        } else {
            ultimo = null;
        }
        tamanho--;
        return item;
    }

    @Override
    public Integer removerFim() {
        if (vazia()) {
            return null;
        }
        Integer item = ultimo.item;
        ultimo = ultimo.anterior;
        if (ultimo != null) {
            ultimo.proximo = null;
        } else {
            primeiro = null;
        }
        tamanho--;
        return item;
    }

    @Override
    public Integer remover(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            return null;
        }

        if (posicao == 0) {
            return removerInicio();
        } else if (posicao == tamanho - 1) {
            return removerFim();
        } else {
            No atual = primeiro;
            for (int i = 0; i < posicao; i++) {
                atual = atual.proximo;
            }
            Integer item = atual.item;
            atual.anterior.proximo = atual.proximo;
            atual.proximo.anterior = atual.anterior;
            tamanho--;
            return item;
        }
    }

    @Override
    public Integer obterInicio() {
        if (vazia()) {
            return null;
        }
        return primeiro.item;
    }

    @Override
    public Integer obterFim() {
        if (vazia()) {
            return null;
        }
        return ultimo.item;
    }

    @Override
    public Integer obter(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            return null;
        }

        No atual = primeiro;
        for (int i = 0; i < posicao; i++) {
            atual = atual.proximo;
        }
        return atual.item;
    }

    @Override
    public int pesquisar(Integer item) {
        No atual = primeiro;
        int posicao = 0;
        while (atual != null) {
            if (atual.item.equals(item)) {
                return posicao;
            }
            atual = atual.proximo;
            posicao++;
        }
        return -1;
    }
}

class ListaArray implements ListaGenerica {

    private Integer[] itens;
    private int tamanho;
    private final int CAPACIDADE_INICIAL = 10;

    public ListaArray() {
        itens = new Integer[CAPACIDADE_INICIAL];
        tamanho = 0;
    }

    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public boolean vazia() {
        return tamanho == 0;
    }

    @Override
    public void inserirInicio(Integer item) {
        if (tamanho == itens.length) {
            aumentarCapacidade();
        }
        System.arraycopy(itens, 0, itens, 1, tamanho);
        itens[0] = item;
        tamanho++;
    }

    @Override
    public void inserirFim(Integer item) {
        if (tamanho == itens.length) {
            aumentarCapacidade();
        }
        itens[tamanho++] = item;
    }

    private void aumentarCapacidade() {
        itens = Arrays.copyOf(itens, itens.length * 2);
    }

    @Override
    public StatusLista inserir(Integer item, int posicao) {
        if (posicao < 0 || posicao > tamanho) {
            return StatusLista.POSICAOINVALIDA;
        }

        if (tamanho == itens.length) {
            aumentarCapacidade();
        }

        System.arraycopy(itens, posicao, itens, posicao + 1, tamanho - posicao);
        itens[posicao] = item;
        tamanho++;
        return StatusLista.SUCESSO;
    }

    @Override
    public Integer removerInicio() {
        if (vazia()) {
            return null;
        }
        Integer item = itens[0];
        System.arraycopy(itens, 1, itens, 0, tamanho - 1);
        tamanho--;
        return item;
    }

    @Override
    public Integer removerFim() {
        if (vazia()) {
            return null;
        }
        return itens[--tamanho];
    }

    @Override
    public Integer remover(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            return null;
        }
        Integer item = itens[posicao];
        System.arraycopy(itens, posicao + 1, itens, posicao, tamanho - posicao - 1);
        return item;
    }

    @Override
    public Integer obterInicio() {
        if (vazia()) {
            return null;
        }
        return itens[0];
    }

    @Override
    public Integer obterFim() {
        if (vazia()) {
            return null;
        }
        return itens[tamanho - 1];
    }

    @Override
    public Integer obter(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            return null;
        }
        return itens[posicao];
    }

    @Override
    public int pesquisar(Integer item) {
        for (int i = 0; i < tamanho; i++) {
            if (itens[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numListas = Integer.parseInt(sc.nextLine());
        String tipoLista = sc.nextLine();
        ListaGenerica lista = null;

        switch (tipoLista) {
            case "S":
                lista = new ListaSimplesmenteEncadeada();
                break;
            case "D":
                lista = new ListaDuplamenteEncadeada();
                break;
            case "A":
                lista = new ListaArray();
                break;
        }

        while (numListas-- > 0) {
            String[] comando = sc.nextLine().split(" ");
            String operacao = comando[0];
            int posicao;
            int valor;

            switch (operacao) {
                case "I":
                    valor = Integer.parseInt(comando[1]);
                    posicao = Integer.parseInt(comando[2]);
                    lista.inserir(valor, posicao);
                    break;
                case "R":
                    posicao = Integer.parseInt(comando[1]);
                    System.out.println(lista.remover(posicao));
                    break;
                case "P":
                    valor = Integer.parseInt(comando[1]);
                    System.out.println(lista.pesquisar(valor));
                    break;
            }
        }

        sc.close();
    }
}

