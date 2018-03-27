import java.util.HashMap;

public class TennisGame implements ScoreBoard {

    private static final String DEUCE = "Deuce";
    private static final String ADVANTAGE ="Advantage" ;
    private String button;
    int playerOneScore=0;
    int playerTwoScore=0;
    private HashMap<Integer, String> runningScore = new HashMap<>();
    private Player player;
    private boolean deuceStarted = false;

    TennisGame() {
        initializeRunningScores();

    }

    private void initializeRunningScores() {
        runningScore.put(1,"Love");
        runningScore.put(2, "Fifteen");
        runningScore.put(3, "Thirty");
        runningScore.put(4, "Forty");
    }

    @Override
    public String pressButton(Player player) {
        this.player = player;
        this.button = player.getButtonLabel();
        player.addScoreToPlayer();
        checkDeuceGame();
        return getDisplay();
    }

    @Override
    public int getScore() {
        return isPlayer1Scored() ? playerOneScore : playerTwoScore;

    }

    private boolean isPlayer1Scored() {
        return button.contains("1");
    }

    private String getDisplay() {
        return player.wonPointLabel();
    }

    

    @Override
    public String getPlayerTotalScore() {
        if(checkDeuceGame()) return DEUCE;
        else if(advantageGame()) return ADVANTAGE;
        else return getRunningScoreDisplay();

    }

    private String getRunningScoreDisplay() {
        return runningScore.get(playerOneScore)+" "+runningScore.get(playerTwoScore);
    }


    private boolean advantageGame() {
         return (deuceStarted && isPlayerHaveAdvantage());
    }

    private boolean isPlayerHaveAdvantage() {
        return (playerOneScore == playerTwoScore +1) || (playerTwoScore == playerOneScore +1);
    }

    private boolean checkDeuceGame() {
        if(checkPlayersScoreIsThreeOrGreater() && checkPlayersHaveSameScore()) return deuceStarted = true;
        return false;
    }

    private boolean checkPlayersScoreIsThreeOrGreater() {
        return playerOneScore >= 3;
    }

    private boolean checkPlayersHaveSameScore() {
        return playerOneScore == playerTwoScore;
    }


    @Override
    public String getRunningScore() {
        return String.valueOf(runningScore.get(getScore()));
    }


    @Override
    public String getWinner() {
        if (playerOneScore > 3 && (playerOneScore >= (playerTwoScore + 2))) return "Win for player1";

        return "Win for player2";
    }
}
