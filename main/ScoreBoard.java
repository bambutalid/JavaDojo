public interface ScoreBoard {
    String pressButton(Player player);

    int getScore();

    String getPlayerTotalScore();

    String getRunningScore();

    String getWinner();
}
