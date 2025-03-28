public class Main {
    public static void main(String[] args) {

        Robot robot = new Robot(1, 3);

        robot.robotTurnOn();

        for (int i = 0; i < 3; i++) {
            try {
                if (robot.getConnection() instanceof RobotConnection) {
                    robot.moveRobotTo(6, 5);

                    return;
                }
            } catch (RobotConnectionException e) {
                throw new RobotConnectionException("Соединение не установленно");
            } finally {
                robot.close();
            }
        }
    }
}
