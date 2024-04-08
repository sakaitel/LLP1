import java.util.Scanner;
class Pedido {
    int codigo;
    int quantidade;
    double preco;

    public Pedido(int cod, int qtde) {
        codigo = cod;
        quantidade = qtde;
        preco = 0.0;
    }

    double definirPreco(int codigo) {
        switch (codigo) {
            case 1:
                return 4.0;
            case 2:
                return 4.5;
            case 3:
                return 5.0;
            case 4:
                return 2.0;
            case 5:
                return 1.5;
        }
        return 0.0;
    }

    void verPrecoDoCodigo() {
        preco = definirPreco(codigo);
    }

    double calcularTotal() {
        return preco * quantidade;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int codigo, qtde;

        codigo = scan.nextInt();
        qtde = scan.nextInt();

        Pedido pedido = new Pedido(codigo, qtde);
        pedido.verPrecoDoCodigo();
        double total = pedido.calcularTotal();
        System.out.printf("Total: R$ %.2f\n", total);
    }
}
