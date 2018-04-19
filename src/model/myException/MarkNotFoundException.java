package model.myException;

public class MarkNotFoundException extends SchoolObjectNotException {
    public MarkNotFoundException() {
        super();
    }

    public MarkNotFoundException(String message) {
        super(message);
    }

    public MarkNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MarkNotFoundException(Throwable cause) {
        super(cause);
    }

    protected MarkNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
