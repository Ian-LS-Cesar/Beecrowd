import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        int numFuncionario = input.nextInt();
        int horasTrabalhadas = input.nextInt();
        double valorHora = input.nextDouble();

        double salario = horasTrabalhadas * valorHora;

        System.out.println("NUMBER = " + numFuncionario);
        System.out.println(String.format("SALARY = U$ %.2f", salario));
        input.close();
    }
}
