package excecoes;

public class EmptyQueueException extends RuntimeException {
    public EmptyQueueException(String errorMessage){
        super(errorMessage);
    }
}
