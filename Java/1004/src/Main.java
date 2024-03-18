import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        int A = input.nextInt();
        int B = input.nextInt();

        int produto = A * B;

        System.out.println("PROD = " + produto);
        input.close();
    }
}