import collections.PilhaEstatica;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        int casosTeste = leitor.nextInt();

        for (int i = 0; i < casosTeste; i++) {
            int quantAlunos = leitor.nextInt();
            int trocaAlunos = quantAlunos;

            PilhaEstatica<Integer> alunos = new PilhaEstatica<>(quantAlunos);

            for (int j = 0; j < quantAlunos; j++) {
                alunos.empilhar(leitor.nextInt());
            }

            int notaMaior = alunos.tirar();

            while (!alunos.estaVazio()) {
                int topo = alunos.topo();

                if (notaMaior > topo) {
                    trocaAlunos -= 2;
                    alunos.tirar();
                } else if (notaMaior == topo) {
                    trocaAlunos -= 1;
                    alunos.tirar();
                } else {
                    notaMaior = topo;
                    alunos.tirar();
                }
            }

            if (alunos.altura() == 1) {
                if (notaMaior > alunos.topo()) {
                    trocaAlunos -= 2;
                }
            }

            if (trocaAlunos < 0) {
                trocaAlunos = 0;
            }

            System.out.println(trocaAlunos);
        }

        leitor.close();
    }
}
