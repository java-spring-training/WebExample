package example.exception;

public class ProductApiErrorException extends Exception {

    public ProductApiErrorException(String message) {
        super(message);
    }
}
