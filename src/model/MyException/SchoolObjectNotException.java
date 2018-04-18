package model.MyException;

public class SchoolObjectNotException extends Exception {

    public SchoolObjectNotException() {
        super();
    }

    public SchoolObjectNotException(String message) {
        super(message);
    }

    public SchoolObjectNotException(String message, Throwable cause) {
        super(message, cause);
    }

    public SchoolObjectNotException(Throwable cause) {
        super(cause);
    }

    protected SchoolObjectNotException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
