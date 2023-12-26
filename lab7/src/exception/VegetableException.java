package exception;

/**
 * Class representing an exception that can occur.
 */
public class VegetableException extends RuntimeException {

    /**
     * Constructs a new exception with the specified detail message.
     * @param message The detail message.
     */
    public VegetableException(String message) {
        super(message);
    }

    /**
     * Constructs a new exception with the specified detail message and cause.
     * @param message The detail message.
     * @param cause The cause of the exception.
     */
    public VegetableException(String message, Throwable cause) {
        super(message, cause);
    }
}
