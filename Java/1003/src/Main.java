import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        int A = input.nextInt();
        int B = input.nextInt();

        int soma = A + B;

        System.out.println("SOMA = " + soma);
        input.close();
    }
}
