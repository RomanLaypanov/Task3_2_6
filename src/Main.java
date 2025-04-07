public class Main {
    public static void main(String[] args) {
        RobotConnectionManager robotConnectionManager = new RobotConnectionManager() {
            @Override
            public RobotConnection getConnection() {
                return new RobotConnection() {
                    @Override
                    public void moveRobotTo(int x, int y) {
                        System.out.println("Робот перемещен в точку (" + x + ", " + y + ")");
                    }

                    @Override
                    public void close() {
                        System.out.println("Соединение закрыто");
                    }
                };
            }
        };


        Robot.moveRobot(robotConnectionManager, 2, 5);
    }
}
