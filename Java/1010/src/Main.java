import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        int codigo1 = input.nextInt();
        int quant1 = input.nextInt();
        double valor1 = input.nextDouble();

        int codigo2 = input.nextInt();
        int quant2 = input.nextInt();
        double valor2 = input.nextDouble();

        double valorTotal = (quant1 * valor1) + (quant2 * valor2);

        System.out.println(String.format("VALOR A PAGAR: R$ %.2f", valorTotal));
        input.close();
    }
}
