package Lesson_1.Marathon;

public class Team {

    private Competitor[] participants = new Competitor[4];

    public Team(Competitor[] participants) {
        int participantNumber = 0;
        for (Competitor eachParticipant: participants) {
            this.participants[participantNumber] = eachParticipant;
            participantNumber++;
        }
    }

    public Competitor[] getTeam() {
        return participants;
    }

    public void getParticipantsInfo() {
        int participantNumber = 1;
        for (Competitor eachParticipant: participants) {
            System.out.println("Информация об участнике # " + participantNumber + ": ");
            eachParticipant.showTypeNname();
            participantNumber++;
            System.out.println();
        }
    }

    public void getFinishedParticipantsInfo() {
        int participantNumber = 1;
        for (Competitor eachParticipant: participants) {
            if (eachParticipant.isOnDistance()) {
                System.out.println("\nУчастник #" + participantNumber + " финишировал");
            }
            participantNumber++;
        }
    }
}
