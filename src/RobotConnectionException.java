public class RobotConnectionException extends RuntimeException {
    public RobotConnectionException(String message) {
        super("Соединение не установлено");
    }

    public RobotConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
