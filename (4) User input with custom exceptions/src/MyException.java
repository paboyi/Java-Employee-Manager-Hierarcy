
public class MyException extends Exception {
    // I can only create MyException() methods inside a MyException class
    // (this is the rule for Custom Exceptions)

    // public FieldLengthLimitException() { super(); }   // this will cause an error.

    public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

}
