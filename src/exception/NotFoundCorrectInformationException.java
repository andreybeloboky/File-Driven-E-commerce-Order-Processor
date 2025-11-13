package exception;

public class NotFoundCorrectInformationException extends IllegalArgumentException {

    public NotFoundCorrectInformationException(String message, Throwable cause) {
        super(message, cause);
    }
}
