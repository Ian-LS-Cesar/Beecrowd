import java.util.Scanner;
import collections.PilhaDinamica;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner leitor = new Scanner(System.in);
        boolean codigo = true;

        while(codigo == true){
            String expressao = leitor.nextLine();
            if (expressao.equals("")){
                codigo = false;
            }else{
                System.out.println(BalancearParenteses(expressao));
            }
        }
        leitor.close();

    }

    private static String BalancearParenteses(String expressao){
        PilhaDinamica<Character> parenteses = new PilhaDinamica<>();
        
        for (char letra : expressao.toCharArray()){
            if(letra == '('){
                parenteses.empilhar(letra);
            
            }else if (letra == ')'){
                
                if(parenteses.estaVazio()){
                    return "incorrect";
                }
                parenteses.tirar();
            }
        }

        if(parenteses.estaVazio()){
            return "correct";
        }else{
            return "incorrect";
        }
    }
}