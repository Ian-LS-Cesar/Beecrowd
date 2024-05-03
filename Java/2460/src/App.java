import java.util.Scanner;

import collections.FilaDinamicaCircular;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner leitor = new Scanner(System.in);
        FilaDinamicaCircular<Integer> filaPessoas = new FilaDinamicaCircular<>();
        
        //Adicionar pessoas na fila
        int tamFila = leitor.nextInt();
    
        for(int i = 0; i < tamFila; i++){
            int codPessoa = leitor.nextInt();
            filaPessoas.enfileirar(codPessoa);
        }
    //Pessoas que sairam
        int quantSairam = leitor.nextInt();
        FilaDinamicaCircular<Integer> pessoasSairam = new FilaDinamicaCircular<>();

        for (int j = 0; j < quantSairam; j++){
            int saiu = leitor.nextInt();
            pessoasSairam.enfileirar(saiu);
        }
            
    //Removendo pessoas
        while (!pessoasSairam.estaVazio()){
            if(pessoasSairam.primeiro() == filaPessoas.primeiro()){
                filaPessoas.desenfileirar();
                pessoasSairam.desenfileirar();
            }else{
                filaPessoas.rotate();
            }
        }
        
    //Girando até o primeiro retornar a sua posição inicial
        for(int l = 0; l < quantSairam + 2; l++){
            filaPessoas.rotate();
        }
        System.out.println(filaPessoas);
        
    }
}



