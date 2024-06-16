import java.util.Scanner;
import collections.*;

public class App{
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        int casosTeste = leitor.nextInt();
        leitor.nextLine();
        
        for(int i = 1; i <= casosTeste; i++){
            String areia = leitor.nextLine();
            System.out.println(contarDiamantes(areia));
        }
        
    }

    public static int contarDiamantes(String areia){
        PilhaDinamica<Character> pilha = new PilhaDinamica<>();

        int quantDiamantes = 0;
        
        for(char letra : areia.toCharArray()){
            if(letra == '<'){
                pilha.empilhar(letra);
            }else if(letra == '>' && !pilha.estaVazio()){
                pilha.tirar();
                quantDiamantes++;
            }
        }
        return quantDiamantes;
    }

}