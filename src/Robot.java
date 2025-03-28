public class Robot implements RobotConnection, RobotConnectionManager {
    private int xR = 0;
    private int yR = 0;
    static String state = "turn of";

    Robot(int xR, int yR) {
        this.xR = xR;
        this.yR = yR;
    }

    public String robotTurnOn() {
        state = "turn on";
        return state;
    }

    public String robotTurnOff() {
        state = "turn of";
        return state;
    }

    @Override
    public void moveRobotTo(int x, int y) {
        xR = x;
        yR = y;
        System.out.println("x = " + xR + ", " + "y = " + yR);
    }

    @Override
    public void close() {
        System.out.println("Соеденение прервано");
    }

    @Override
    public RobotConnection getConnection() {
        RobotConnection robotConnection = new RobotConnection() {
            @Override
            public void moveRobotTo(int x, int y) {
            }

            @Override
            public void close() {
            }
        };

        if (state.equals("turn on")) {
            return robotConnection;
        } else {
            throw new RobotConnectionException("Соединение не установленно");
        }
    }
}