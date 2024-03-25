import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int codigo, alcool = 0, gasolina = 0, diesel = 0;
        do
            codigo = scan.nextInt();
        while (codigo < 1 || codigo > 4);

        while (codigo != 4) {
            switch (codigo) {
                case 1:
                    alcool++;
                    break;
                case 2:
                    gasolina++;
                    break;
                case 3:
                    diesel++;
            }
            codigo = scan.nextInt();
        }
        System.out.printf("MUITO OBRIGADO\nAlcool: %d\nGasolina: %d\nDiesel: %d\n", alcool, gasolina, diesel);
    }
}
