package tennisgame;

public class TennisGame {

    interface Score {
        String LOVE = "Love";
        String FIFTEEN = "15";
        String THIRTY = "30";
        String FORTY = "40";
        String DEUCE = "Deuce";
        String ADVANTAGE = "Advantage";
    }

    public String firstPlayerName = "player1";

    public String secondPlayerName = "player2";

    public int firstPlayerPoints = 0;

    public int secondPlayerPoints = 0;

    public void getPoint(String playerName) {
        if (playerName.equals(firstPlayerName)) {
            firstPlayerPoints++;
        } else {
            secondPlayerPoints++;
        }
    }

    public String score() {
        String firstPartScore = Score.LOVE;
        String secondPartScore = Score.LOVE;
        if (firstPlayerPoints == secondPlayerPoints) {
            if (firstPlayerPoints == 1) {
                firstPartScore = Score.FIFTEEN;
                secondPartScore = Score.FIFTEEN;
            } else if (firstPlayerPoints == 2) {
                firstPartScore = Score.THIRTY;
                secondPartScore = Score.THIRTY;
            } else if (firstPlayerPoints >= 3) {
                firstPartScore = Score.DEUCE;
                secondPartScore = "";
            }
        } else if ((firstPlayerPoints >= 4 || secondPlayerPoints >= 4)) {
            if (Math.abs(firstPlayerPoints - secondPlayerPoints) >= 2) {
                firstPartScore = "Win";
                secondPartScore = firstPlayerPoints > secondPlayerPoints ? firstPlayerName : secondPlayerName;
            } else {
                firstPartScore = Score.ADVANTAGE;
                secondPartScore = "";
            }
        } else {
            if (firstPlayerPoints == 1) {
                firstPartScore = Score.FIFTEEN;
            } else if (firstPlayerPoints == 2) {
                firstPartScore = Score.THIRTY;
            } else if (firstPlayerPoints == 3) {
                firstPartScore = Score.FORTY;
            }
            if (secondPlayerPoints == 1) {
                secondPartScore = Score.FIFTEEN;
            } else if (secondPlayerPoints == 2) {
                secondPartScore = Score.THIRTY;
            } else if (secondPlayerPoints == 3) {
                secondPartScore = Score.FORTY;
            }
        }
        return secondPartScore.isEmpty() ? firstPartScore : firstPartScore + "-" + secondPartScore;
    }
}
