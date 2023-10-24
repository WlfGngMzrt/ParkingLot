package exception;

public class InvalidRequestDataException extends RuntimeException{
    public InvalidRequestDataException() {
        super();
    }

    public InvalidRequestDataException(String message) {
        super(message);
    }

    public InvalidRequestDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidRequestDataException(Throwable cause) {
        super(cause);
    }

    protected InvalidRequestDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
