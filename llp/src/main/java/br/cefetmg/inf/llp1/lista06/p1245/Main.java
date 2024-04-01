import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n, num, duplas;
        char letra;
        while (scan.hasNext()) {
            n = scan.nextInt();
            duplas = 0;
            int D[] = new int[61];
            int E[] = new int[61];
            for (int j = 0; j < n; j++) {
                num = scan.nextInt();
                letra = scan.next().charAt(0);
                if (letra == 'D') {
                    D[num]++;
                } else if (letra == 'E') {
                    E[num]++;
                }
            }
            for (int i = 30; i <= 60; i++) {
                if (D[i] < E[i]) {
                    duplas += D[i];
                } else {
                    duplas += E[i];
                }
            }
            System.out.printf("%d\n", duplas);
        }
    }
}
