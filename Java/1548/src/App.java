import java.util.Scanner;
import collections.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Scanner leitor = new Scanner(System.in);

        int casosTeste = leitor.nextInt();
        int quantAlunos = leitor.nextInt();

        for(int i = 0; i < casosTeste; i++){
            UnsortedPriorityQueue<Integer, Integer> notas = new UnsortedPriorityQueue<>();
            for (int j = 0; j < quantAlunos; j++){     
                int nota = leitor.nextInt();
                notas.insert(nota,nota);
                
            }
        }
    }
}
