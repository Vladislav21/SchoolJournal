package model.myException;

public class InvalidValueOfTeacherException extends InvalidSchoolValueException {
    public InvalidValueOfTeacherException() {
        super();
    }

    public InvalidValueOfTeacherException(String message) {
        super(message);
    }

    public InvalidValueOfTeacherException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidValueOfTeacherException(Throwable cause) {
        super(cause);
    }

    protected InvalidValueOfTeacherException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
