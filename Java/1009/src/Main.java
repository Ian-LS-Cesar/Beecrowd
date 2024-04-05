import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        String nome = input.nextLine();
        double salario = input.nextDouble();
        double montante = input.nextDouble();

        double total = salario + (montante * 0.15);
        
        System.out.println(String.format("TOTAL = R$ %.2f", total));
    }
}
