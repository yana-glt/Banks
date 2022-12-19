package exception_handlers;

public class WrongValueTypeException extends Exception {
    private static final long serialVersionUID = 1L;

    public WrongValueTypeException(String mess) {
        super(mess);
    }
}
