import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int impar = 1, x;
        x = scan.nextInt();
        do {
            System.out.printf("%d\n", impar);
            impar += 2;
        } while (impar <= x);
    }
}
