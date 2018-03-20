import java.util.HashMap;

public class TennisGame implements ScoreBoard {
    private static final String DEUCE = "Deuce";
    private static final String ADVANTAGE ="Advantage" ;
    private String button;
    public int playerOneScore=0;
    public int playerTwoScore=0;
    HashMap runningScore = new HashMap();
    private Player player;
    private boolean deuceStarted = false;

    public TennisGame() {
        initializeRunningScores();

    }

    private void initializeRunningScores() {
        runningScore = new HashMap();
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
        if(checkDeuceGame()){
            return DEUCE;
        }else if(advantageGame()){
            return ADVANTAGE;

        }else{
            return (runningScore.get(playerOneScore)+" "+runningScore.get(playerTwoScore));
        }
    }


    private boolean advantageGame() {
         return (deuceStarted && isPlayerHaveAdvantage());
    }

    private boolean isPlayerHaveAdvantage() {
        return (playerOneScore == playerTwoScore +1) || (playerTwoScore == playerOneScore +1);
    }

    private boolean checkDeuceGame() {
        if((playerOneScore >= 3) && (playerOneScore == playerTwoScore)){
            deuceStarted = true;
            return true;
            }
        return false;
    }


    @Override
    public String getRunningScore() {
        return String.valueOf(runningScore.get(getScore()));
    }


    @Override
    public String getWinner() {
        if (playerOneScore > 3 && (playerOneScore >= (playerTwoScore + 2))) return "Win for player1";

        return null;
    }
}
