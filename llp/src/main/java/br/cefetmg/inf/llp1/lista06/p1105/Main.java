import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int b, n;
        loop: while (true) {
            b = scan.nextInt();
            n = scan.nextInt();
            if (b==0)
                break;
            int banco[][] = new int[3][20];
            for (int i = 0; i < b; i++) {
                banco[0][i] = 0; //dividas
                banco[1][i] = 0; //pagamentos
                banco[2][i] = 0; //reserva
            }
            for (int j = 0; j < b; j++) {
                banco[2][j] = scan.nextInt();
            }
            for (int k = 0; k < n; k++) {
                int d, c, v;
                d = scan.nextInt();
                c = scan.nextInt();
                v = scan.nextInt();
                if (d != 0 & c != 0) {
                    banco[0][d - 1] += v;
                    banco[1][c - 1] += v;
                }
            }
            for (int i = 0; i < b; i++) {
                banco[2][i] -= banco[0][i];
                banco[2][i] += banco[1][i];
                if (banco[2][i] < 0) {
                    System.out.println('N');
                    continue loop;
                }
            }
            System.out.println('S');
        }
    }
}
