package homework_1;

public class Main {
    public static void main(String[] args) {
        /*Cat cat = new Cat("Барсик");
        cat.jump();
        cat.run();

        Human human = new Human("Сергей", false, 0, 0);
        human.jump();
        human.run();

        Robot robot = new Robot("Фёдор");
        robot.jump();
        robot.run();*/

        Track track = new Track(50);
        Wall wall = new Wall(5);

        Course course = new Course(track, wall);

        Human[] humans = new Human[] {
                new Human("Сергей", false, 80, 6),
                new Human("Владимир",  false, 40, 7),
                new Human("Дмитрий", false, 70, 4),
                new Human("Даниил", false, 30, 2)
        };

        Team team = new Team("Чемпионы", humans);

        course.start(team);
    }

}
