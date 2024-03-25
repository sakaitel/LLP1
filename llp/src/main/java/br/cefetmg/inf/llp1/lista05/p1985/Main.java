
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int comprados, total_lido = 0, codigo, quantidade;
        double preco = 0, preco_total = 0;
        comprados = scan.nextInt();
        while (total_lido < comprados) {
            codigo = scan.nextInt();
            quantidade = scan.nextInt();
            switch (codigo) {
                case 1001:
                    preco = 1.5;
                    break;
                case 1002:
                    preco = 2.5;
                    break;
                case 1003:
                    preco = 3.5;
                    break;
                case 1004:
                    preco = 4.5;
                    break;
                case 1005:
                    preco = 5.5;
                    break;
            }
            preco_total += (preco * quantidade);
            total_lido++;
        }

        System.out.printf("%.2f\n", preco_total);
    }
}
