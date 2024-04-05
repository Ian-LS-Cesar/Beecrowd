import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        double raio = input.nextDouble();
        double volume = (4/3.0) * 3.14159 * (raio * raio * raio);

        System.out.println(String.format("VOLUME = %.3f", volume));
        input.close();
    }
}
