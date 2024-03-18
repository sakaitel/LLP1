import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1, num2, tmp, soma = 0;
        num1 = scan.nextInt();
        num2 = scan.nextInt();
        if (num1 > num2) {
            tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        if (num1%2==0)
            num1++;
        else
            num1+=2;
        for (int i=num1; i<num2; i=i+2) {
            soma += i;
        }
        System.out.printf("%d\n", soma);
    }
}