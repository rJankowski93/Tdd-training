package tennisgame;

import org.junit.Test;

import static org.junit.Assert.*;

public class TennisGameTest {

    @Test
    public void player1ShouldBeOnePoint() {
        //given
        TennisGame tennisGame = new TennisGame();
        String firstPlayerName = "player1";
        tennisGame.firstPlayerPoints = 0;

        //when
        tennisGame.getPoint(firstPlayerName);

        //then
        assertEquals(1, tennisGame.firstPlayerPoints);
    }


    @Test
    public void player2ShouldBeOnePoint() {
        //given
        TennisGame tennisGame = new TennisGame();
        String secondPlayerName = "player2";
        tennisGame.secondPlayerPoints = 0;

        //when
        tennisGame.getPoint(secondPlayerName);

        //then
        assertEquals(1, tennisGame.secondPlayerPoints);
    }

    @Test
    public void shouldReturnLoveToLove() throws Exception {
        //given
        TennisGame tennisGame = new TennisGame();
        tennisGame.firstPlayerPoints = 0;
        tennisGame.secondPlayerPoints = 0;

        //when
        String score = tennisGame.score();

        //then
        assertEquals("Love-Love", score);

    }


    @Test
    public void shouldReturn15ToLove() throws Exception {
        //given
        TennisGame tennisGame = new TennisGame();
        tennisGame.firstPlayerPoints = 1;
        tennisGame.secondPlayerPoints = 0;

        //when
        String score = tennisGame.score();

        //then
        assertEquals("15-Love", score);
    }

    @Test
    public void shouldReturn15To15() throws Exception {
        //given
        TennisGame tennisGame = new TennisGame();
        tennisGame.firstPlayerPoints = 1;
        tennisGame.secondPlayerPoints = 1;

        //when
        String score = tennisGame.score();

        //then
        assertEquals("15-15", score);
    }


    @Test
    public void shouldReturn30To15() throws Exception {
        //given
        TennisGame tennisGame = new TennisGame();
        tennisGame.firstPlayerPoints = 2;
        tennisGame.secondPlayerPoints = 1;

        //when
        String score = tennisGame.score();

        //then
        assertEquals("30-15", score);
    }

    @Test
    public void shouldReturn30To40() throws Exception {
        //given
        TennisGame tennisGame = new TennisGame();
        tennisGame.firstPlayerPoints = 2;
        tennisGame.secondPlayerPoints = 3;

        //when
        String score = tennisGame.score();

        //then
        assertEquals("30-40", score);
    }


    @Test
    public void shouldWin1Player() throws Exception {
        //given
        TennisGame tennisGame = new TennisGame();
        tennisGame.firstPlayerPoints = 4;
        tennisGame.secondPlayerPoints = 0;
        tennisGame.firstPlayerName="Player1";

        //when
        String score = tennisGame.score();

        //then
        assertEquals("Win-Player1", score);
    }

    @Test
    public void shouldReturnDeuce() throws Exception {
        //given
        TennisGame tennisGame = new TennisGame();
        tennisGame.firstPlayerPoints = 5;
        tennisGame.secondPlayerPoints = 5;

        //when
        String score = tennisGame.score();

        //then
        assertEquals("Deuce", score);
    }

    @Test
    public void shouldReturnAdvantage() throws Exception {
        //given
        TennisGame tennisGame = new TennisGame();
        tennisGame.firstPlayerPoints = 8;
        tennisGame.secondPlayerPoints = 9;

        //when
        String score = tennisGame.score();

        //then
        assertEquals("Advantage", score);
    }
}