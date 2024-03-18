import java.util.Scanner;

public class Main {
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int total, numero, mult_2 = 0, mult_3 = 0, mult_4 = 0, mult_5 = 0;    
        total= scan.nextInt();
        for (int i = 0; i < total; i++){
            numero = scan.nextInt();
            if (numero % 2 == 0)
                mult_2++;
            if (numero % 3 == 0)
                mult_3++;
            if (numero % 4 == 0)
                mult_4++;
            if (numero % 5 == 0)
                mult_5++;
        }
        System.out.printf("%d Multiplo(s) de 2\n%d Multiplo(s) de 3\n%d Multiplo(s) de 4\n%d Multiplo(s) de 5\n", mult_2, mult_3, mult_4, mult_5);
    }
}