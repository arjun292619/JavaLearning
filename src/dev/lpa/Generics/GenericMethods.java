package dev.lpa.Generics;

interface Player {
    String name();
}

record BaseballPlayer(String name, String position) implements Player {
}

record FootBallPlayer(String name, String position) implements Player {
}

public class GenericMethods {
    public static void main(String[] args) {
        BaseballTeam phillies = new BaseballTeam("Philadelphia Phillies");
        BaseballTeam astros = new BaseballTeam("Houston Astros");
        scoreResult(phillies, 3, astros, 5);
        BaseballPlayer harper = new BaseballPlayer("B Harper", "Right Fielder");
        BaseballPlayer marsh = new BaseballPlayer("D Marsh", "Right Fielder");
        phillies.addTeamMember(harper);
        phillies.addTeamMember(marsh);
        phillies.listTeamMembers();

        SportsTeam afc = new SportsTeam("Adelaide Cross");
        FootBallPlayer tex = new FootBallPlayer("T Roosevelt", "center forward");
        FootBallPlayer reagan = new FootBallPlayer("R Reagan", "center forward");
        afc.addTeamMember(tex);
        afc.addTeamMember(reagan);
        afc.addTeamMember(harper);
        afc.listTeamMembers();

        Team<Player> genericTeam = new Team<>("Generic Team");
        genericTeam.addTeamMember(tex);
        genericTeam.addTeamMember(reagan);
        genericTeam.addTeamMember(harper);
//        genericTeam.addTeamMember("A Donald");
        genericTeam.listTeamMembers();

        Team<FootBallPlayer> genericFbTeam = new Team<>("Generic FootBall Team");
        genericFbTeam.addTeamMember(tex);
        genericFbTeam.addTeamMember(reagan);
//        genericFbTeam.addTeamMember(harper);
        genericFbTeam.listTeamMembers();

    }

    public static void scoreResult(BaseballTeam team1, int score1, BaseballTeam team2, int score2) {
        String message = team1.setScore(score1, score2);
        team2.setScore(score2, score1);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }
}
