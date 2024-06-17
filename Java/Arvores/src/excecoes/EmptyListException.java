package excecoes;

public class EmptyListException extends RuntimeException {
    public EmptyListException(String errorMessage){
        super(errorMessage);
    }
}
