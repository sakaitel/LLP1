
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1, num2, tmp, soma;
        while (true) {
            soma = 0;
            num1 = scan.nextInt();
            num2 = scan.nextInt();
            if (num1 > num2) {
                tmp = num1;
                num1 = num2;
                num2 = tmp;
            }
            if (num1 <= 0 || num2 <= 0) {
                break;
            } else {
                for (; num1 <= num2; num1++) {
                    System.out.printf("%d ", num1);
                    soma += num1;
                }
                System.out.printf("Sum=%d\n", soma);
            }
        }
    }
}
