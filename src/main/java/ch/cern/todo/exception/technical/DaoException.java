package ch.cern.todo.exception.technical;


public class DaoException extends RuntimeException  {

    private Long id;

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoException(Throwable cause) {
        super(cause);
    }

    public DaoException(String message) {
        super(message);
    }
}
