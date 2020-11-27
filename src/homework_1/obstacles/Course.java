package homework_1.obstacles;

import homework_1.participants.Team;
import homework_1.participants.Participant;

public class Course {
    protected Track track;
    protected Wall wall;

    public Course(Track track, Wall wall) {
        this.track = track;
        this.wall = wall;
    }

    public void start(Team team) {
        for (Participant participant : team.getParticipants()) {
            if (participant.disqualification()) {
                participant.jump(wall.getHeight());
            }
            if (participant.disqualification()) {
                participant.run(track.getLength());
            }
        }
    }

}
