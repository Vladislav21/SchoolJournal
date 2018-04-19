package model.myException;

public class SchoolClassNotFoundException extends SchoolObjectNotException {
    public SchoolClassNotFoundException() {
        super();
    }

    public SchoolClassNotFoundException(String message) {
        super(message);
    }

    public SchoolClassNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SchoolClassNotFoundException(Throwable cause) {
        super(cause);
    }

    protected SchoolClassNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
