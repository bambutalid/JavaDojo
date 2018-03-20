public class Player {
    int playerNumber;
    public int score=0;
    TennisGame game;

    public Player(int playerNumber, TennisGame game) {
        this.playerNumber = playerNumber;
        this.game = game;
    }

    public int getPlayer(){
        return playerNumber;
    }

    public String getButtonLabel() {
        return playerNumber == 1 ? "Player 1 Scores": "Player 2 Scores";
    }

    public String wonPointLabel() {
        return playerNumber == 1 ? "won-point(player1)" :  "won-point(player2)";
    }

    public int addScoreToPlayer(){
        ++score;
        setTennisGameScoreBasedFromPlayerScores();
        return score;
    }

    private void setTennisGameScoreBasedFromPlayerScores(){
        if(playerNumber==1) game.playerOneScore=score;
                else game.playerTwoScore=score;
    }
}
