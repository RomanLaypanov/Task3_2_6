public class Robot {

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        RobotConnectionException lastException = null;

        for (int attempt = 0; attempt < 3; attempt++) {
            RobotConnection connection = null;

            try {
                connection = robotConnectionManager.getConnection();
                connection.moveRobotTo(toX, toY);

                try {
                    connection.close();
                } catch (Exception ignored) {
                }
                return;
            } catch (RobotConnectionException e) {
                lastException = e;
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Exception ignored) {
                    }
                }
            } catch (Exception e) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Exception ignored) {
                    }
                }
                throw e;
            }
        }

        throw new RobotConnectionException("Не удалось после 3 попыток", lastException);
    }
}
