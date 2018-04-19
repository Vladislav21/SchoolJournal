package model.myException;

public class InvalidValueOfSchoolSubjectException extends InvalidSchoolValueException {
    public InvalidValueOfSchoolSubjectException() {
        super();
    }

    public InvalidValueOfSchoolSubjectException(String message) {
        super(message);
    }

    public InvalidValueOfSchoolSubjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidValueOfSchoolSubjectException(Throwable cause) {
        super(cause);
    }

    protected InvalidValueOfSchoolSubjectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
