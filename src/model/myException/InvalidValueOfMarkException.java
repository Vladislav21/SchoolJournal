package model.myException;

public class InvalidValueOfMarkException extends InvalidSchoolValueException {
    public InvalidValueOfMarkException() {
        super();
    }

    public InvalidValueOfMarkException(String message) {
        super(message);
    }

    public InvalidValueOfMarkException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidValueOfMarkException(Throwable cause) {
        super(cause);
    }

    protected InvalidValueOfMarkException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
