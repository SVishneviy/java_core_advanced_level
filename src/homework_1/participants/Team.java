package homework_1.participants;

public class Team {
    protected String name;
    protected Participant[] participants;

    public Team(String name, Participant[] participants) {
        this.name = name;
        this.participants = participants;
    }

    public Participant[] getParticipants() {
        return participants;
    }

}
