public class Robot {

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) throws RobotConnectionException {
        RobotConnection connection = null;

        for (int attempt = 0; attempt < 3; attempt++) {
            try {
                connection = robotConnectionManager.getConnection();
                connection.moveRobotTo(toX, toY);
                break;
            } catch (RobotConnectionException e) {
                if (attempt == 2) {
                    throw e;
                }
            } catch (Exception e) {
                throw e;
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (Exception ignored) {}
            }
        }
    }
}
