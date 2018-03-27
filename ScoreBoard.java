public interface ScoreBoard {
    String pressButton(Player player);

    int getWhichPlayerScored();

    String getPlayerTotalScore();

    String getRunningScore();

    String getWinner();
}
