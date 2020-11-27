package homework_1;

import homework_1.obstacles.Course;
import homework_1.obstacles.Track;
import homework_1.obstacles.Wall;
import homework_1.participants.*;

public class Main {
    public static void main(String[] args) {

        Track track = new Track(50);
        Wall wall = new Wall(5);

        Course course = new Course(track, wall);

        Participant[] participants = new Participant[] {
                new Human("Сергей", false, 80, 6),
                new Cat("Мурзик",  false, 40, 7),
                new Robot("Фёдор", false, 70, 4),
                new Human("Даниил", false, 30, 2)
        };

        Team team = new Team("Чемпионы", participants);

        course.start(team);

        for (Participant participant : team.getParticipants()) {
            participant.info();
        }

    }

}
