package excecoes;

public class FullQueueException extends RuntimeException {
    public FullQueueException(String errorMessage){
        super(errorMessage);
    }
}
