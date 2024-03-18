import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num_casos, quantia, coelhos = 0, ratos = 0, sapos = 0;
        double cobaias;
        char animal;
        
        num_casos = scan.nextInt();
        while (num_casos > 0) {
            quantia = scan.nextInt();
            animal = scan.next().charAt(0);
            switch(animal){
                case 'C': coelhos += quantia;
                        break;
                case 'R': ratos += quantia;
                        break;
                default: sapos += quantia;
            }
            num_casos--;
        }

        cobaias = coelhos + ratos + sapos;

        System.out.printf("Total: %.0f cobaias\n", cobaias);
        System.out.printf("Total de coelhos: %d\n", coelhos);
        System.out.printf("Total de ratos: %d\n", ratos);
        System.out.printf("Total de sapos: %d\n", sapos);
        System.out.printf("Percentual de coelhos: %.2f %%\n", (coelhos / cobaias) * 100);
        System.out.printf("Percentual de ratos: %.2f %%\n", (ratos / cobaias) * 100);
        System.out.printf("Percentual de sapos: %.2f %%\n", (sapos / cobaias) * 100);

    }
}
