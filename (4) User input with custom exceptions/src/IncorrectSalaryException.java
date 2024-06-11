public class IncorrectSalaryException extends Exception{
    // every method in this class must be named after the class.

    public IncorrectSalaryException() {
        super();
    }

    public IncorrectSalaryException(String message) {
        super(message);
    }

    public IncorrectSalaryException(String message, Throwable cause) {
        super(message, cause);
    }

}
