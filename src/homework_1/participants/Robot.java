package homework_1.participants;

public class Robot implements Participant {
    protected String name;
    private boolean disqualification;
    private final int MAX_DISTANCE;
    private final int MAX_HEIGHT;

    public Robot(String name, boolean disqualification, int MAX_DISTANCE, int MAX_HEIGHT) {
        this.name = name;
        this.disqualification = disqualification;
        this.MAX_DISTANCE = MAX_DISTANCE;
        this.MAX_HEIGHT = MAX_HEIGHT;
    }

    @Override
    public boolean disqualification() {
        return !disqualification;
    }

    @Override
    public void jump(int height) {
        if (height <= MAX_HEIGHT) {
            System.out.printf("%s прыгнул на %d метров.\n", name, height);
        } else {
            System.out.printf("%s не прыгнул на %d метров.\n", name, height);
            disqualification = true;
        }
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_DISTANCE) {
            System.out.printf("%s пробежал %d метров.\n", name, distance);
        } else {
            System.out.printf("%s не пробежал %d метров.\n", name, distance);
            disqualification = true;
        }
    }

    @Override
    public void info() {
        if (!disqualification) {
            System.out.printf("%s участвует.\n", name);
        } else {
            System.out.printf("%s дисквалефицирован.\n", name);
        }
    }

}
