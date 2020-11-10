package homework_1;

public class Human implements Jumping, Running {
    private String name;
    private boolean disqualification;
    private final int MAX_DISTANCE;
    private final int MAX_HEIGHT;

    public Human(String name, boolean disqualification, int MAX_DISTANCE, int MAX_HEIGHT) {
        this.name = name;
        this.disqualification = disqualification;
        this.MAX_DISTANCE = MAX_DISTANCE;
        this.MAX_HEIGHT = MAX_HEIGHT;
    }

    public String getName() {
        return name;
    }

    public boolean isDisqualification() {
        return disqualification;
    }

    public void setDisqualification(boolean disqualification) {
        this.disqualification = disqualification;
    }

    public int getMAX_DISTANCE() {
        return MAX_DISTANCE;
    }

    public int getMAX_HEIGHT() {
        return MAX_HEIGHT;
    }

    @Override
    public void jump() {
        System.out.printf("%s прыгает.\n", name);
    }

    @Override
    public void run() {
        System.out.printf("%s бегает.\n", name);
    }

}
