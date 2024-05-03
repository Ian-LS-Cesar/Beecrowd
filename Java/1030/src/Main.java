import collections.CircularLinkedQueue;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner leitor = new Scanner(System.in);
        

        int casosTeste = leitor.nextInt();
        int a = 0;
        int casosOcorridos = 0;
        while (a < casosTeste){    
            
            CircularLinkedQueue<Integer> pessoas = new CircularLinkedQueue<>();
            
            int quantPessoas = leitor.nextInt();
            int tamSalto = leitor.nextInt();
            
            for(int j = 1; j <= quantPessoas; j++){
                pessoas.enqueue(j);   
            }


            while(quantPessoas > 1){
                for(int l = 1; l < tamSalto; l++){
                    pessoas.rotate();
                    
                }
                int l = 1;
                pessoas.dequeue();
                quantPessoas--;
            }
            casosOcorridos++;
            System.out.println("Case " + casosOcorridos  +": " + pessoas.first());
            pessoas.dequeue();
            casosTeste--;
        }

        
    } 
}

