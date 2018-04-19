package model.myException;

public class InvalidSchoolValueException extends Exception {
    public InvalidSchoolValueException() {
        super();
    }

    public InvalidSchoolValueException(String message) {
        super(message);
    }

    public InvalidSchoolValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidSchoolValueException(Throwable cause) {
        super(cause);
    }

    protected InvalidSchoolValueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
