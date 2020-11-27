package homework_1;

public class Course {
    private Track track;
    private Wall wall;

    public Course(Track track, Wall wall) {
        this.track = track;
        this.wall = wall;
    }

    public void start(Team team) {
        for(Human human : team.getHumans()) {
            if (!human.isDisqualification()) {
                if (track.getLength() < human.getMAX_DISTANCE()) {
                    human.run();
                } else {
                    human.setDisqualification(true);
                    System.out.printf("%s не смог пробежать.\n", human.getName());
                }
            }
            if (!human.isDisqualification()) {
                if (wall.getHeight() < human.getMAX_HEIGHT()) {
                    human.jump();
                } else {
                    human.setDisqualification(true);
                    System.out.printf("%s не смог перепрыгнуть.\n", human.getName());
                }
            }
        }
    }

}
