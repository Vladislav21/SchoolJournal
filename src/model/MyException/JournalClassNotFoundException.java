package model.MyException;

public class JournalClassNotFoundException extends SchoolObjectNotException {
    public JournalClassNotFoundException() {
        super();
    }

    public JournalClassNotFoundException(String message) {
        super(message);
    }

    public JournalClassNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public JournalClassNotFoundException(Throwable cause) {
        super(cause);
    }

    protected JournalClassNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
