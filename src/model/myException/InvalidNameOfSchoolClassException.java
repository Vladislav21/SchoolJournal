package model.myException;

public class InvalidNameOfSchoolClassException extends InvalidSchoolValueException {
    public InvalidNameOfSchoolClassException() {
        super();
    }

    public InvalidNameOfSchoolClassException(String message) {
        super(message);
    }

    public InvalidNameOfSchoolClassException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidNameOfSchoolClassException(Throwable cause) {
        super(cause);
    }

    protected InvalidNameOfSchoolClassException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
