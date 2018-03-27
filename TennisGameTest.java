
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TennisGameTest {
    private TennisGame game;
    private Player player1, player2;

    @Before
    public void setUp() {
        game= new TennisGame();
        player1= new Player(1, game);
        player2= new Player(2, game);
    }

    private void pressButtonForPlayer(Player playerNumber, int numberOfTimesToPressButton) {
        for(int iterateButtonPress=0; iterateButtonPress < numberOfTimesToPressButton; iterateButtonPress++)
            game.pressButton(playerNumber);

    }


    @Test
    public void testToGetPlayerNumber(){
        assertEquals(1, player1.getPlayer());
        assertEquals(2, player2.getPlayer());
    }

    @Test
    public void testPlayerOneWonPoint() {

        assertEquals("won-point(player1)", game.pressButton( player1));
        assertEquals(1, player1.score);

    }

    @Test
    public void testPlayerTwoWonPoint(){
        assertEquals("won-point(player2)",  game.pressButton(player2));
        assertEquals(1, player2.score);
    }

    @Test
    public void testPlayerOneWonTwoPoint(){
        assertEquals("won-point(player1)", game.pressButton(player1));
        assertEquals("won-point(player1)", game.pressButton(player1));
        assertEquals(2, player1.score);
    }

    @Test
    public void testGetPlayersTotalScore(){
        pressButtonForPlayer(player1, 2);
        pressButtonForPlayer(player2, 1);
        assertEquals("Fifteen Love", game.getPlayerTotalScore());
    }

    @Test
    public void testLoveRunningScore(){
        pressButtonForPlayer(player1, 1);
        assertEquals("Love", game.getRunningScore());
        pressButtonForPlayer(player1, 1);
        assertEquals("Fifteen", game.getRunningScore());
        pressButtonForPlayer(player1, 1);
        assertEquals("Thirty", game.getRunningScore());
        pressButtonForPlayer(player1, 1);
        assertEquals("Forty", game.getRunningScore());
    }

    @Test
    public void testDeuceGame(){
        pressButtonForPlayer(player1, 3);
        pressButtonForPlayer(player2, 3);
        assertEquals("Deuce", game.getPlayerTotalScore());
    }

    @Test
    public void testAdvantageGame(){
        pressButtonForPlayer(player1, 3);
        pressButtonForPlayer(player2, 3);
        pressButtonForPlayer(player1, 1);
        assertEquals("Advantage", game.getPlayerTotalScore());
    }

    @Test
    public void testPlayer1Wins(){
        pressButtonForPlayer(player1, 4);
        assertEquals("Win for player1", game.getWinner());
    }

    @Test
    public void testPlayer2Wins(){
        pressButtonForPlayer(player2, 4);
        assertEquals("Win for player2", game.getWinner());
    }

    @Test
    public void testCloseGame(){
        pressButtonForPlayer(player1, 3);
        pressButtonForPlayer(player2, 3);
        assertEquals("Deuce", game.getPlayerTotalScore());
        pressButtonForPlayer(player1, 1);
        assertEquals("Advantage", game.getPlayerTotalScore());
        pressButtonForPlayer(player2, 1);
        assertEquals("Deuce", game.getPlayerTotalScore());
        pressButtonForPlayer(player2, 1);
        assertEquals("Advantage", game.getPlayerTotalScore());
        pressButtonForPlayer(player1, 1);
        assertEquals("Deuce", game.getPlayerTotalScore());
        pressButtonForPlayer(player1, 1);
        assertEquals("Advantage", game.getPlayerTotalScore());
        pressButtonForPlayer(player1, 1);
        assertEquals("Win for player1", game.getWinner());
    }







}
