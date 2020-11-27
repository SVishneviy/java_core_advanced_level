package homework_1;

public class Team {
    private String name;
    private Human[] humans;

    public Team(String name, Human[] humans) {
        this.name = name;
        this.humans = humans;
    }

    public Human[] getHumans() {
        return humans;
    }

}
